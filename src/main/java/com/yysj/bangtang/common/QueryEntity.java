package com.yysj.bangtang.common;

import java.util.List;

public class QueryEntity {
	/**
	 * 属性
	 */
	private String attribute;
	/**
	 * 操作
	 */
	private String operation;
	/**
	 * 操作的值
	 */
	private List<Object> values;
	
	public QueryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QueryEntity(String attribute, String operation, List<Object> values) {
		super();
		this.attribute = attribute;
		this.operation = operation;
		this.values = values;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public List<Object> getValues() {
		return values;
	}
	public void setValues(List<Object> values) {
		this.values = values;
	}
	
}
