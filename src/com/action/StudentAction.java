package com.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.beans.Student;
import com.beans.Teacher;
import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class StudentAction {
	
	private int stuId;
	private int status;
	
	public String queryAll(){
		StudentDao stuDao=new StudentDaoImpl();
		List<Student> stuList=stuDao.queryAll();
		ActionContext.getContext().put("stuList", stuList);
		return "stuquery";
	}
	
	public void updateSq() throws Exception{
		StudentDao stuDao=new StudentDaoImpl();
		if(stuDao.updateSq(stuId, status)){
			ServletActionContext.getResponse().getWriter().print("success");
		}
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
