package com.beans;

import java.util.Set;

public class Teacher {
	
	private int id;
	private String teaName;
	private String password;
	private String keCheng;
	
	private int teaStatus;  //只是为了装载数据
	
	
	public int getTeaStatus() {
		return teaStatus;
	}
	public void setTeaStatus(int teaStatus) {
		this.teaStatus = teaStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKeCheng() {
		return keCheng;
	}
	public void setKeCheng(String keCheng) {
		this.keCheng = keCheng;
	}
	
	
	

}
