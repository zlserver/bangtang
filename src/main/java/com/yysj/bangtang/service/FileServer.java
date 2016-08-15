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
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.file.FilePath;
import com.yysj.bangtang.task.ImageSizerTask;
import com.yysj.bangtang.utils.Config;
import com.yysj.bangtang.utils.ImageSizer;
import com.yysj.bangtang.utils.ServiceUtils;
import com.yysj.bangtang.utils.StreamTool;
import com.yysj.bangtang.utils.TokenGenerator;

/**
 * 用于处理移动端发过来带图片或者短视频的动态，采用socket传输。
 * 发布的动态有两种：1.图片[文字]2.短视频[文字]。 文字可选，如果发送带纯文字的动态可使用其它方法。
 * 移动端在链接服务器端socket时会先发送一个请求头，请求头由头字段和字段值组成，每个头字段以分号(;)相隔。头内容如下：
 * Content-Type=pic;Piccount=3;Content-Length=143253434;token=5511ca0210cfbangbang@zhouliang@163.com;filename=xxx.3gp;text=第1条动态
 * 每个头字段的含义：
 * Content-Type：传过来的动态中包含的文件是图片还是视频，可选值为pic/video
 * Piccount:如果Content-Type值为pic，则Piccount表示将会传过来几张图片，否则该值为空字符串
 * Content-Length:传过来文件的大小，如果Content-Type值为video，则表示短视频的大小；如果Content-Type值为pic，则表示传过来的图片的大小，多张图片以逗号(,)相隔，
 * 例如Piccount=2，则Content-Length=237213,673822。
 * token:表示用户的令牌值。
 * filename:表示传过来的文件名称，同样如果传过来的是图片，表示图片的没名称，多张图片以逗号(,)相隔。
 * text:发表的动态内容的文字信息。
 * @author xcitie
 *
 */
@Service("fileServer")
public class FileServer {
	 private   int port=7871;//监听端口
	 private boolean quit = false;//退出
	 private ServerSocket server;
	 private FilePath filePath;
	 private ContentService contentService;
	 //线程池
	 private ThreadPoolTaskExecutor taskExecutor;
	 
	 public FileServer(){
		 //this.port = port;
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
			           taskExecutor.execute(new SocketTask(socket));
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
						String datapath=ServiceUtils.getDateFileDir(null);
						relativePath+=datapath;
						abPath+=relativePath;
						//原图片保存路径
						File dir = new File(abPath);
						//压缩图片保存路径
						File compdir = new File(abPath+"/compress");
						if(!dir.exists()) 
							dir.mkdirs();
						if( !compdir.exists())
							compdir.mkdirs();
						//上传图片个数
						int count =Integer.parseInt(piccount);
						//新建count个图片文件，和对应文件输出流，每个文件的大小
						File[] pics = new File[count]; //存放原图片
						File[] compresspics = new File[count]; //存放压缩图片
						FileOutputStream[] fos=new FileOutputStream[count]; //原图片输出流
						String[] pissiezestr= filelength.split(","); //每个图片文件的大小str
						long[] picsizes=new long[count]; //每个图片文件的大小long
						String[] filenames= filename.split(",");//每个图片的名称
						StringBuffer picSavePath = new StringBuffer(relativePath);//图片保存路径
						for( int i =0;i<count;i++){
							
							String savename = ServiceUtils.getDateFileName(null)+"."+ServiceUtils.getExtFromFileName(filenames[i]);
							//新建原图片存放文件
							pics[i]= new File(dir, savename);
							//压缩图片存放文件
							compresspics[i]=new File(compdir,savename);
							fos[i]=new FileOutputStream(pics[i]);
							picsizes[i]=Long.parseLong(pissiezestr[i]);
							
							picSavePath.append(",").append(savename);
						}
						content.setPicSavePath(picSavePath.toString());
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
						
						//传输数据
						byte[] buffer = new byte[102400];
						int len = -1;
						long length = 0;
						int index=0; //从第一个文件开始接收数据
						//压缩图片的宽度
						int width =Integer.parseInt(Config.getKey(Config.CONTENTPIC_COMPRESSWIDTH));
						while( (len=inStream.read(buffer)) != -1){//从输入流中读取数据写入到文件中
							length += len;
							if( length>=picsizes[index])
							{
								length-=len;
								int sulen =(int) (picsizes[index]-length);
								fos[index].write(buffer, 0, sulen);
								//开启线程压缩图片
								new Thread(new ImageSizerTask(pics[index], compresspics[index], width, ServiceUtils.getExtFromFileName(filenames[index]))).start();
								
								index++;//下一个文件
								if( index<count)
								  fos[index].write(buffer, sulen,len-sulen);
								length=len-sulen;
							}else{
								fos[index].write(buffer, 0, len);
							}
						}
							
							//保存动态信息
							contentService.publish(content);
							
							//关闭流
							for(int j=0;j<count;j++)
								if( fos[j]!=null)
								fos[j].close();
							inStream.close();
							outStream.close();
					}else //上传视频
						if( contentType.equals("video")){
							long filesize= Long.parseLong(filelength);
							//上传内容保存路径
							String abPath =filePath.getPath(FilePath.FILE_ROOT);
							String relativePath = filePath.getPath(FilePath.CONTENT_VIDEO);
							//相对路径目录下在加上当前时间目录
							String datapath=ServiceUtils.getDateFileDir(null);
							relativePath+=datapath;
							abPath+=relativePath;
							
							File dir = new File(abPath);
							if(!dir.exists()) 
								dir.mkdirs();
							String savename = ServiceUtils.getDateFileName(null)+"."+ServiceUtils.getExtFromFileName(filename);;
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
	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	@Autowired
	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	 

}
