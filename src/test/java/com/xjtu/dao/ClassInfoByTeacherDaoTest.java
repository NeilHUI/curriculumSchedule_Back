package com.xjtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjtu.BaseTest;
import com.xjtu.entity.ClassInfoByTeacher;

public class ClassInfoByTeacherDaoTest extends BaseTest{

	 @Autowired
	    private ClassInfoByTeacherDao classInfoByTeacherDao;


	    @Test
	    public void insertTeacher() throws Exception {
	        ClassInfoByTeacher ClassInfoByTeacher = new ClassInfoByTeacher();
	        ClassInfoByTeacher.setTerm("setTerm");
	        ClassInfoByTeacher.setTeacher("fanzhijie");
	        ClassInfoByTeacher.setWeek("setWeek");
	        ClassInfoByTeacher.setLesson("数据挖掘");
	        ClassInfoByTeacher.setInfo("#######");
	        classInfoByTeacherDao.insertTeacher(ClassInfoByTeacher);
	    }

	    @Test
	    public void queryByKeyWithTeacher() throws Exception {
	        List<ClassInfoByTeacher> lists = new ArrayList<>();
	        lists = classInfoByTeacherDao.queryByKeyWithTeacher("setTerm","fanzhijie");
	        for (ClassInfoByTeacher list : lists) {
	            System.out.println(list);
	        }

	    }

	}
