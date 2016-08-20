package com.yysj.bangtang.redis;

public class PublishContentThread implements Runnable {

	private RContent rc;
	private RContentDao rContentDao;
	
	public PublishContentThread(RContent rc,RContentDao rContentDao) {
		super();
		this.rc = rc;
		this.rContentDao = rContentDao;
	}

	public void run() {
		// TODO Auto-generated method stub
		rContentDao.publish(rc);
	}

}
