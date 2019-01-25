package com.dao;

import java.util.List;

import com.beans.Student;
import com.beans.Teacher;

public interface StudentDao {
	
	public Student login(String name,String password);
	
	public List<Student> queryAll();
	public boolean updateSq(int stuId,int status);
}
