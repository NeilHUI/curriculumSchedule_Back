package com.xjtu.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjtu.entity.ClassInfoByTeacher;

public interface ClassInfoByTeacherDao {

    /**
     * 添加教师进入数据库
     *
     * @param classInfoByTeacher
     * @return 返回受影响的行数
     */
    int insertTeacher(ClassInfoByTeacher classInfoByTeacher);

    /**
     * 查询数据库 返回课程实体
     *
     * @param term
     * @param tecaher
     * @return
     */
    List<ClassInfoByTeacher> queryByKeyWithTeacher(@Param("term") String term, @Param("teacher") String teacher);
}
