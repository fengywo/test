package com.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Student;
import com.beans.Teacher;
import com.beans.stu_tea;
import com.dao.TeacherDao;
import com.opensymphony.xwork2.ActionContext;
import com.util.HibUtil;

public class TeacherDaoImpl implements TeacherDao {

	public Teacher login(String name, String password) {
		Session s=null;
		try{
			s=HibUtil.getSession();
			return (Teacher)s.createQuery("from Teacher where teaName=? and password=?")
			.setParameter(0, name).setParameter(1, password).uniqueResult();
		}finally{
			HibUtil.close(s);
		}
	}

	public List<Teacher> queryAll() {
		Session s=null;
		try{
			s=HibUtil.getSession();
			List<Teacher> teaList=s.createQuery("from Teacher").list();
			for(Teacher tea:teaList){
				int teaId=tea.getId();
				Student stu=(Student)ActionContext.getContext().getSession().get("sstu");
				int stuId=stu.getId();
				stu_tea st=(stu_tea)s.createQuery("from stu_tea where stuId=? and teaId=?")
				.setParameter(0, stuId).setParameter(1, teaId).uniqueResult();
				if(st!=null){
					int status=st.getStatus();
					tea.setTeaStatus(status);
				}else{
					tea.setTeaStatus(3);
				}
			}
			return teaList;
		}finally{
			HibUtil.close(s);
		}
	}

	public boolean addSq(int teaId) {
		Session s=null;
		Transaction tx=null;
		try{
			s=HibUtil.getSession();
			tx=s.beginTransaction();
			stu_tea st=new stu_tea();
			st.setStatus(0);
			st.setTeaId(teaId);
			Student stu=(Student)ActionContext.getContext().getSession().get("sstu");
			int stuId=stu.getId();
			st.setStuId(stuId);
			int result=(Integer)s.save(st);
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
