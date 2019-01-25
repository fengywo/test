package com.beans;

import java.util.Set;

public class Student {
	
	private int id;
	private String stuName;
	private String password;
	
	
	private int stuStatus;  //只是为了装载数据
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStuStatus() {
		return stuStatus;
	}
	public void setStuStatus(int stuStatus) {
		this.stuStatus = stuStatus;
	}
	
	
	
}
