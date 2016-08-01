package com.yysj.bangtang.task;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.yysj.bangtang.utils.EmailUtils;
/**
 * 发送邮箱服务，该服务中有3个优先级的任务队列，发送邮箱任务时按照从高到低优先级依次发送。
 * 
 * @author xcitie
 *
 */
public class EmailService implements  Runnable{
	
	//任务队列
	private static Map<String,List<EmailTask>> taskQueue=new HashMap<String,List<EmailTask>>();
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
    
	public void run() {
		while(true){
			synchronized (taskQueue) {
				if( taskQueue.size()>0 ){
					//按优先级高低依次选择任务执行
					EmailTask task=chooseTask();
					try {
						if( task !=null)
						EmailUtils.sendEmail(task.getToEmail(), task.getSendContent(),task.getSubject());
					} catch (AddressException e) {
						e.printStackTrace();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	//按优先级高低依次执行任务
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
}
