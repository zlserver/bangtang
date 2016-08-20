package com.yysj.bangtang.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import com.yysj.bangtang.task.EmailTask;
import com.yysj.bangtang.task.EmailTask.TaskPriority;
import com.yysj.bangtang.utils.EmailUtils;
/**
 * 发送邮箱服务，该服务中有3个优先级的任务队列，发送邮箱任务时按照从高到低优先级依次发送。
 * 
 * @author xcitie
 *
 */
@Service
public class EmailService{
	 //线程池
	private ThreadPoolTaskExecutor taskExecutor;
	private boolean quit = false;//退出
	private MailSender mailSender;
	
	public EmailService() {
		 System.out.println("邮箱服务类构造成功");
	}

	//任务队列
	private static Map<String,List<EmailTask>> taskQueue=new HashMap<String,List<EmailTask>>();
	//添加任务
	public static void addTask(EmailTask task){
		synchronized (taskQueue) {
			//按照优先级来插入任务，优先级越高任务越靠前
			String takstag=task.getPriority().toString();
			List<EmailTask> degreetasks=taskQueue.get(takstag);
			if(degreetasks==null)
				degreetasks= new LinkedList<EmailTask>();
			degreetasks.add(task);
			taskQueue.put(takstag, degreetasks);
		}
	}
	 /**
	  * 启动服务
	  * @throws Exception
	  */
	@PostConstruct
	 public void start() throws Exception{
		 System.out.println("邮件服务类start");
		 new Thread(new Runnable() {
			public void run() {
				while(!quit){
					synchronized (taskQueue) {
						if( taskQueue.size()>0 ){
							//按优先级高低依次选择任务执行
							EmailTask task=chooseTask();
							try {
								if( task !=null){
									task.setMailSender(mailSender);
									//为支持多用户并发访问，采用线程池管理每一个用户的连接请求
									taskExecutor.execute(task);
								}
								//EmailUtils.sendEmail(task.getToEmail(), task.getSendContent(),task.getSubject());
							} catch (Exception e) {
								e.printStackTrace();
							} 
						}
					}
				}
			}
		}).start();

		 System.out.println("邮件服务类start end");
	 }
	 /**
	  * 退出
	  */
	@PreDestroy
	 public void quit(){

		System.out.println("邮件服务类quit");
		this.quit = true;
	 }
    
	//按优先级从高到低选择要执行的任务
	private EmailTask chooseTask(){
		List<EmailTask> htasks =taskQueue.get(EmailTask.TaskPriority.PRIORITY_HIGH.toString());
		if(htasks!=null){
			if(htasks.size()>0 )
				return htasks.remove(0);
			else
				taskQueue.remove(EmailTask.TaskPriority.PRIORITY_HIGH.toString());
		}
		List<EmailTask> ntasks =taskQueue.get(EmailTask.TaskPriority.PRIORITY_NORMAL.toString());
		if(ntasks!=null){
			if(ntasks.size()>0 )
				return ntasks.remove(0);
			else
				taskQueue.remove(EmailTask.TaskPriority.PRIORITY_NORMAL.toString());
		}
		List<EmailTask> ltasks =taskQueue.get(EmailTask.TaskPriority.PRIORITY_LOW.toString());
		if(ltasks!=null){
			if(ltasks.size()>0 )
				return ltasks.remove(0);
			else
				taskQueue.remove(EmailTask.TaskPriority.PRIORITY_LOW.toString());
		}
		return null;
	}
	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}
	@Autowired
	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	public MailSender getMailSender() {
		return mailSender;
	}	
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	 
}
