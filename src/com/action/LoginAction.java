package com.action;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.beans.Student;
import com.beans.Teacher;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.impl.StudentDaoImpl;
import com.dao.impl.TeacherDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.HibUtil;

public class LoginAction extends ActionSupport{
	
	private String name;
	private String password;
	private String change;
	
	
	
	public String login(){
		system.out.print();
		if("1".equals(change)){
			StudentDao stuDao=new StudentDaoImpl();
			Student stu=stuDao.login(name, password);
			if(stu!=null){
				ActionContext.getContext().getSession().put("sstu", stu);
				ActionContext.getContext().getSession().put("s", 1);
				return "success";
			}else{
				return "loginErr";
			}
		}
		
		
		
		if("2".equals(change)){
			TeacherDao teaDao=new TeacherDaoImpl();
			Teacher tea=teaDao.login(name, password);
			if(tea!=null){
				ActionContext.getContext().getSession().put("stea", tea);
				ActionContext.getContext().getSession().put("s", 2);
				return "success";
			}else{
				return "loginErr";
			}
		}
		systen.out.print("123123");
		systen.out.print("123123");
		return "loginErr";
	}
	
	
	public static void main(String[] args) {
		Session s=HibUtil.getSession();
		Transaction tx=s.beginTransaction();
		Student stu=new Student();
		stu.setStuName("aaa");
		stu.setPassword("123");
		s.save(stu);
		tx.commit();
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
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	
	

}
