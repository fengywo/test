package com.dao;

import java.util.List;

import com.beans.Teacher;

public interface TeacherDao {
	public Teacher login(String name,String password);
	
	public List<Teacher> queryAll();
	public boolean addSq(int teaId);
}
