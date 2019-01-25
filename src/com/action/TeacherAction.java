package com.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.beans.Teacher;
import com.dao.TeacherDao;
import com.dao.impl.TeacherDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class TeacherAction {
	
	private int teaId;
	
	public String queryAll(){
		TeacherDao teaDao=new TeacherDaoImpl();
		List<Teacher> teaList=teaDao.queryAll();
		ActionContext.getContext().put("teaList", teaList);
		return "teaquery";
	}
	
	public void addSq() throws Exception{
		TeacherDao teaDao=new TeacherDaoImpl();
		if(teaDao.addSq(teaId)){
			ServletActionContext.getResponse().getWriter().print("success");
		}
	}
	
	

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}

}
