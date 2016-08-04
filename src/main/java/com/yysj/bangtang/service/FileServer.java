package com.yysj.bangtang.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.file.FilePath;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.StreamTool;
import com.yysj.bangtang.utils.TokenGenerator;

//用于处理Android端上传过来的大文件，采用socket传输
@Service("fileServer")
public class FileServer {
	 private ExecutorService executorService;//线程池
	 private   int port=7871;//监听端口
	 private boolean quit = false;//退出
	 private ServerSocket server;
	 private FilePath filePath;
	 private ContentService contentService;
	 
	 
	 public FileServer(){
		 //this.port = port;
		 //创建线程池，池中具有(cpu个数*50)条线程
		 executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 50);
		 System.out.println("文件服务类构造成功");
	 }
	 /**
	  * 退出
	  */
	@PreDestroy
	 public void quit(){

		System.out.println("文件服务类quit");
		this.quit = true;
		try {
			server.close();
			
		} catch (IOException e) {
		}
	 }
	 /**
	  * 启动服务
	  * @throws Exception
	  */
	@PostConstruct
	 public void start() throws Exception{

		 System.out.println("文件服务类start");
		 new Thread(new Runnable() {
			public void run() {
				 try {
					server = new ServerSocket(port);
					 while(!quit){
				         
			           Socket socket = server.accept();
			           //为支持多用户并发访问，采用线程池管理每一个用户的连接请求
			           executorService.execute(new SocketTask(socket));
				     }
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}).start();

  		 System.out.println("文件服务类start end");
	 }
	 
	 private final class SocketTask implements Runnable{
		private Socket socket = null;
		public SocketTask(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			
			try {
				System.out.println("accepted connection "+ socket.getInetAddress()+ ":"+ socket.getPort());
				PushbackInputStream inStream = new PushbackInputStream(socket.getInputStream());
				//得到客户端发来的第一行协议数据：Content-Type=pic;Piccount=3;Content-Length=143253434;token=5511ca0210cfbangbang@zhouliang@163.com;filename=xxx.3gp;text=第1条动态
				String head = StreamTool.readLine(inStream);
					
				if(head!=null){
					//下面从协议数据中提取各项参数值
					String[] items = head.split(";");
					//上传内容类型,图片：pic;视频:video
					String contentType = items[0].substring(items[0].indexOf("=")+1);
					//如果上传的是图片，则该属性表示将会上传几张图片，如果上传类型是视频则该值为null
					String piccount =items[1].substring(items[1].indexOf("=")+1);
					
					//如果上传的是视频则该值表示上传视频的大小，如果上传的是图片则该值为null
					String filelength = URLDecoder.decode(items[2].substring(items[2].indexOf("=")+1),"utf-8");
					
					String token = URLDecoder.decode(items[3].substring(items[3].indexOf("=")+1), "UTF-8");
					String filename = URLDecoder.decode(items[4].substring(items[4].indexOf("=")+1), "UTF-8");
					String text = URLDecoder.decode(items[5].substring(items[5].indexOf("=")+1), "UTF-8");
					System.out.println("contentType："+ contentType+" piccount:"+piccount+" filelength:"+filelength+" token:"+token+" filename:"+filename+" text:"+text);
					

					OutputStream outStream = socket.getOutputStream();
					//回复客户端可以传输数据了
					String response = "status=1\r\n";
					//服务器收到客户端的请求信息后，给客户端返回响应信息：status=1
					outStream.write(response.getBytes());
					
					
					String ip =socket.getLocalAddress().getHostAddress();
					String email = TokenGenerator.getEmail(token);
				
					Content content =new Content();
					content.setEmail(email);
					content.setIp(ip);
					content.setText(text);
					//上传图片
					if( contentType.equals("pic")){
						//上传内容保存路径
						String abPath =filePath.getPath(FilePath.FILE_ROOT);
						String relativePath = filePath.getPath(FilePath.CONTENT_PIC);
						//相对路径目录下在加上当前时间目录
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
						String datapath=sdf.format(new Date());
						relativePath+=datapath;
						abPath+=relativePath;
						File dir = new File(abPath);
						if(!dir.exists()) 
							dir.mkdirs();
						
						//上传图片个数
						int count =Integer.parseInt(piccount);
						//新建count个图片文件，和对应文件输出流，每个文件的大小
						File[] pics = new File[count];
						FileOutputStream[] fos=new FileOutputStream[count];
						String[] pissiezestr= filelength.split(",");
						String[] filenames= filename.split(",");
						long[] picsizes=new long[count];
						StringBuffer picSavePath = new StringBuffer(relativePath);
						for( int i =0;i<count;i++){
							String savename = ServiceUtils.getDateFileName(null)+"."+ServiceUtils.getExtFromFileName(filenames[i]);
							picSavePath.append(",").append(savename);
							pics[i]= new File(dir, savename);
							fos[i]=new FileOutputStream(pics[i]);
							picsizes[i]=Long.parseLong(pissiezestr[i]);

							System.out.println("文件"+i+""+filenames[i]+",大小："+picsizes[i]);
						}
						content.setPicSavePath(picSavePath.toString());
						
						//传输数据
						byte[] buffer = new byte[102400];
						int len = -1;
						long length = 0;
						int i=0;
							/*当前传输的文件已传输完毕，应该传输下一个文件
							 * a.png  5
							 * b.png  6
							 * c.png  3
							 * d.png  1
							 * 总共14
							 * length =0;
							 * buffer=2
						    loop读取次数      1      2      3     4      5      6      7     8
							 *  buffer  2      2      2      2      2     2      2     1
							 *  length  2      4     6(4)    3      5     7(5)   3     4(3)
							 *取buffer  [0,2] [0,2]  [0,1]  
							 * afos[0]  2      4      5               
							 *取buffer               [1,2]  [0,2]  [0,2] [0,1]  
							 * bfos[1]                 1      3     5     6     
							 *取buffer                                   [1,2]  [0,2]  [0,0]
							 * cfos[2]                                     1     3
							 *取buffer                                                 [0,1]
							 * dfos[3]                                                  1
							 * length   2      4      1      3       5     1     3      1 
							 */
							while( (len=inStream.read(buffer)) != -1){//从输入流中读取数据写入到文件中
								
								length += len;
								if( length>picsizes[i])
								{
									length-=len;
									
									int sulen =(int) (picsizes[i]-length);
									fos[i].write(buffer, 0, sulen);
									i++;//下一个文件
									System.out.println("第"+i+"个文件");
									length=len-sulen;
									if( i<count)
									fos[i].write(buffer, sulen,len-sulen);
									
								}else{
									fos[i].write(buffer, 0, len);
								}
							}
							//压缩图片
							
							//保存动态信息
							contentService.publish(content);
							
							//关闭流
							for(int j=0;j<count;j++)
								if( fos[i]!=null)
								fos[i].close();
							inStream.close();
							outStream.close();
					}else //上传视频
						if( contentType.equals("video")){
							long filesize= Long.parseLong(filelength);
							//上传内容保存路径
							String abPath =filePath.getPath(FilePath.FILE_ROOT);
							String relativePath = filePath.getPath(FilePath.CONTENT_VIDEO);
							//相对路径目录下在加上当前时间目录
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
							String datapath=sdf.format(new Date());
							relativePath+=datapath;
							abPath+=relativePath;
							
							File dir = new File(abPath);
							if(!dir.exists()) 
								dir.mkdirs();
							SimpleDateFormat namesdf = new SimpleDateFormat("yyyyMMddhhMMss");
							String savename = namesdf.format(new Date())+"."+ServiceUtils.getExtFromFileName(filename);;
							File confile = new File(dir, savename);
							
							
							RandomAccessFile fileOutStream = new RandomAccessFile(confile, "rwd");
							fileOutStream.seek(0);//移动文件指定的位置开始写入数据
							byte[] buffer = new byte[102400];
							int len = -1;
							long length = 0;
							while( (len=inStream.read(buffer)) != -1){//从输入流中读取数据写入到文件中
								fileOutStream.write(buffer, 0, len);
								length += len;
							}
							
							if(length==filesize) 
							{
								//文件上传完成
								content.setVideoSavePath(relativePath+"/"+savename);
								contentService.publish(content);
							}
							fileOutStream.close();					
							inStream.close();
							outStream.close();
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
	            try {
	                if(socket!=null && !socket.isClosed()) socket.close();
	                //保存或更新文件
	            } catch (IOException e) {}
	        }
		}
	 }

	public FilePath getFilePath() {
		return filePath;
	}
	@Autowired
	public void setFilePath(FilePath filePath) {
		this.filePath = filePath;
	}
	public ContentService getContentService() {
		return contentService;
	}
	@Autowired
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	 

}
