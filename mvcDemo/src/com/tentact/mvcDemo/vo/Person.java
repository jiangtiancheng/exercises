package com.tentact.mvcDemo.vo;

public class Person {
	private int id;
	private String name;
	private String password;
	private int status;//用户的状态。0为待审核，1为审核过了，2为审核被拒绝
	
	
	public Person() {
		super();
	}
	public Person(int id, String name, String password, int status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.status = status;
	}
	public Person(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
