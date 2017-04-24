package com.xjtu.dao;

import com.xjtu.BaseTest;
import com.xjtu.entity.ClassInfoByCourse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by llh.xjtu on 17-4-24.
 */
public class ClassInfoByCourseDaoTest extends BaseTest {

    @Autowired
    private ClassInfoByCourseDao classInfoByCourseDao;


    @Test
    public void insertCourse() throws Exception {
        ClassInfoByCourse classInfoByCourse = new ClassInfoByCourse();
        classInfoByCourse.setTerm("setTerm");
        classInfoByCourse.setCourse("setListContent");
        classInfoByCourse.setWeek("setWeek1");
        classInfoByCourse.setLesson("setLesson1");
        classInfoByCourse.setInfo("setInfo1");
        classInfoByCourseDao.insertCourse(classInfoByCourse);
    }

    @Test
    public void queryByKeyWithCourse() throws Exception {
        List<ClassInfoByCourse> lists = new ArrayList<>();
        lists = classInfoByCourseDao.queryByKeyWithCourse("setTerm","setListContent");
        for (ClassInfoByCourse list : lists) {
            System.out.println(list);
        }

    }

}