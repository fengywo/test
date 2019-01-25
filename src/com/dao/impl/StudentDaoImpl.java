package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Student;
import com.beans.Teacher;
import com.beans.stu_tea;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionContext;
import com.util.HibUtil;

public class StudentDaoImpl implements StudentDao {

	public Student login(String name, String password) {
		Session s=null;
		try{
			s=HibUtil.getSession();
			return (Student)s.createQuery("from Student where stuName=? and password=?")
			.setParameter(0, name).setParameter(1, password).uniqueResult();
		}finally{
			HibUtil.close(s);
		}
	}

	public List<Student> queryAll() {
		Session s=null;
		try{
			s=HibUtil.getSession();
			List<Student> stuList=s.createQuery("from Student").list();
			for(Student stu:stuList){
				int stuId=stu.getId();
				Teacher tea=(Teacher)ActionContext.getContext().getSession().get("stea");
				int teaId=tea.getId();
				stu_tea st=(stu_tea)s.createQuery("from stu_tea where stuId=? and teaId=?")
				.setParameter(0, stuId).setParameter(1, teaId).uniqueResult();
				if(st!=null){
					int status=st.getStatus();
					stu.setStuStatus(status);
				}else{
					stu.setStuStatus(3);
				}
			}
			return stuList;
		}finally{
			HibUtil.close(s);
		}
	}

	public boolean updateSq(int stuId, int status) {
		Session s=null;
		Transaction tx=null;
		try{
			s=HibUtil.getSession();
			tx=s.beginTransaction();
			Teacher tea=(Teacher)ActionContext.getContext().getSession().get("stea");
			int teaId=tea.getId();
			int result=s.createQuery("update stu_tea set status=? where stuId=? and teaId=?")
			.setParameter(0, status).setParameter(1, stuId).setParameter(2, teaId).executeUpdate();
			tx.commit();
			if(result>0){
				return true;
			}
		}finally{
			HibUtil.close(s);
		}
		return false;
	}

}
