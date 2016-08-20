package com.yysj.bangtang.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yysj.bangtang.bean.Client;

public class ContentVo {
	private List<MultipartFile> files;
	private String text;
	private String email;
	private String ip;
	private Client client;
	
	public ContentVo(String text, String email, String ip) {
		super();
		this.text = text;
		this.email = email;
		this.ip = ip;
	}
	public ContentVo( String text, String email, String ip,List<MultipartFile> files,Client client) {
		super();
		this.files = files;
		this.text = text;
		this.email = email;
		this.ip = ip;
		this.client = client;
	}
	
	public ContentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "ContentVo [files=" + files + ", text=" + text + ", email=" + email + ", ip=" + ip + "]";
	}
	
}
