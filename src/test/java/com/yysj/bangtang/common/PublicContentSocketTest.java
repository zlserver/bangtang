package com.yysj.bangtang.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.URLEncoder;
import java.net.UnknownHostException;

import org.junit.Test;

import com.yysj.bangtang.utils.StreamTool;

public class PublicContentSocketTest {

	@Test
	public void publishVideo() throws InterruptedException{
		
		try {
			Socket socket = new Socket("127.0.0.1", 7871);
			//要上传的视频
			File video =new File("G://Wildlife.wmv");
			if( video.exists()){
				//得到客户端发来的第一行协议数据：Content-Type=pic;Piccount=3;Content-Length=143253434;token=5511ca0210cfbangbang@zhouliang@163.com;filename=xxx.3gp;text=第1条动态
				String filename= video.getName();
				long length = video.length();
				String text=URLEncoder.encode("第7条视频动态","utf-8");
				String token =URLEncoder.encode("5511ca0210ce6fc7ee7ce5e69d7ba8dfbangbang@zhouliangbiyesheji@163.com","utf-8");
				
				String head = "Content-Type=video;Piccount=;Content-Length="+length+";"+token+";filename="+filename+";text="+text+"\r\n";
				OutputStream os = socket.getOutputStream();
				//发送给服务器端
				os.write(head.getBytes());
				
				//读取服务器端信息
				PushbackInputStream inStream = new PushbackInputStream(socket.getInputStream());
				String response= StreamTool.readLine(inStream);
				System.out.println(response);
				
				
				String[] items = response.split(";");
				String status=items[0].substring(items[0].indexOf("=")+1);
				System.out.println("--status:"+status);
				if( status.equals("1")){
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(video));
					byte[] buffer = new byte[1024];
					int len =-1;
					while( (len=bis.read(buffer))!=-1){
						os.write(buffer, 0, len);
						os.flush();
					}
					bis.close();
				}
				os.close();
				socket.close();
			}else
				System.out.println("文件不存在");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void publishPic() throws InterruptedException{
		
		try {
			Socket socket = new Socket("127.0.0.1", 7871);
			//要上传的视频
			int count =3;
			StringBuffer filename= new StringBuffer();
			StringBuffer length=new StringBuffer();
			File[] pics= new File[count];
			for( int i= 0;i <count;i++){
				pics[i] = new File("G://"+(i+1)+".jpg");
				filename.append(pics[i].getName()).append(",");
				length.append(pics[i].length()).append(",");
			}
			
			
				//得到客户端发来的第一行协议数据：Content-Type=pic;Piccount=3;Content-Length=143253434;token=5511ca0210cfbangbang@zhouliang@163.com;filename=xxx.3gp;text=第1条动态
				
				String text=URLEncoder.encode("第一条socket图片动态，3张图片","utf-8");
				String token =URLEncoder.encode("5511ca0210ce6fc7ee7ce5e69d7ba8dfbangbang@zhouliangbiyesheji@163.com","utf-8");
				String filenameu=URLEncoder.encode(filename.toString().substring(0, filename.lastIndexOf(",")),"utf-8");
				String lengthu=URLEncoder.encode(length.toString().substring(0, length.lastIndexOf(",")),"utf-8");
				String head = "Content-Type=pic;Piccount="+count+";Content-Length="+lengthu+";"+token+";filename="+filenameu+";text="+text+"\r\n";
				OutputStream os = socket.getOutputStream();
				//发送给服务器端
				os.write(head.getBytes());
				
				//读取服务器端信息
				PushbackInputStream inStream = new PushbackInputStream(socket.getInputStream());
				String response= StreamTool.readLine(inStream);
				System.out.println(response);
				
				
				String[] items = response.split(";");
				String status=items[0].substring(items[0].indexOf("=")+1);
				System.out.println("--status:"+status);
				if( status.equals("1")){
					for( int i =0;i < 3;i++){
						FileInputStream fis=new FileInputStream(pics[i]);
						BufferedInputStream bis = new BufferedInputStream(fis);
						byte[] buffer = new byte[1024];
						int len =-1;
						while( (len=bis.read(buffer))!=-1){
							os.write(buffer, 0, len);
							os.flush();
						}
						fis.close();
						bis.close();
					}
				}
				os.close();
				socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
