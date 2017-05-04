package com.xjtu.dao;

import com.xjtu.BaseTest;
import com.xjtu.entity.ClassInfoByOptional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by llh.xjtu on 17-5-1.
 */
public class ClassInfoByOptionalDaoTest extends BaseTest {

    @Autowired
    private ClassInfoByOptionalDao classInfoByOptionalDao;

    @Test
    public void insertCourse() throws Exception {
        ClassInfoByOptional classInfoByOptional = new ClassInfoByOptional();
        classInfoByOptional.setTerm("setTerm");
        classInfoByOptional.setSchool("setSchool");
        classInfoByOptional.setClassId("setClassId");
        classInfoByOptional.setClassName("setClassName");
        classInfoByOptional.setClassCount("setClassCount");
        classInfoByOptional.setClassTeacher("setClassTeacher");
        classInfoByOptionalDao.insertCourse(classInfoByOptional);

    }

    @Test
    public void queryByKeyWithOptional() throws Exception {
        System.out.println(classInfoByOptionalDao.queryByKeyWithOptional("20161","1"));
    }

}