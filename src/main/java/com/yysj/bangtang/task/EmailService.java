package com.yysj.bangtang.task;

import java.util.LinkedList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.yysj.bangtang.utils.EmailUtils;

public class EmailService implements  Runnable{
	
	//任务队列
	private static List<ActiveEmailTask> tasks =new LinkedList<ActiveEmailTask>();
	
	public static void addTask(ActiveEmailTask task){
		synchronized (tasks) {
			tasks.add(task);
		}
	}
                                               																																																																																																																																																																																								                                                                                            
	public void run() {
		while(true){
			synchronized (tasks) {
				if( tasks.size()>0 ){
					ActiveEmailTask task = tasks.remove(0);
					try {
						EmailUtils.sendActiveEmail(task.getToEmail(), task.getActiveCode());
					} catch (AddressException e) {
						e.printStackTrace();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
