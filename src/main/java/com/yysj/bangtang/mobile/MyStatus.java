package com.yysj.bangtang.mobile;

import com.yysj.bangtang.myenum.OperationStatus;

public class MyStatus {

	private int status;
	private String message;
	
	public MyStatus(OperationStatus status) {
		super();
		this.status = status.getStatus();
		this.message =status.getMessage();
	}
	public MyStatus() {
		super();
		// TODO Auto-generated constructor stub

		this.status = OperationStatus.SUCCESS.getStatus();
		this.message =OperationStatus.SUCCESS.getMessage();
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setOperationStatus(OperationStatus status){

		this.status = status.getStatus();
		this.message =status.getMessage();
	}
}
