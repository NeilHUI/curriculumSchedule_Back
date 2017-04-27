package com.xjtu.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjtu.BaseTest;
import com.xjtu.entity.ClassInfoByClass;


public class ClassInfoByClassDaoTest extends BaseTest{
	 @Autowired
	    private ClassInfoByClassDao classInfoByClassDao;


	    @Test
	    public void insertClass() throws Exception {
	        ClassInfoByClass classInfoByClass = new ClassInfoByClass();
	        classInfoByClass.setTerm("setTerm");
	        classInfoByClass.setClassname("setClassname");
	        classInfoByClass.setWeek("setWeek1");
	        classInfoByClass.setLesson("setLesson1");
	        classInfoByClass.setInfo("setInfo1");
	        classInfoByClassDao.insertClass(classInfoByClass);
	    }

	    @Test
	    public void queryByKeyWithClass() throws Exception {
	        List<ClassInfoByClass> lists = new ArrayList<>();
	        lists = classInfoByClassDao.queryByKeyWithClass("setTerm","setClassname");
	        for (ClassInfoByClass list : lists) {
	            System.out.println(list);
	        }

	    }

	}
