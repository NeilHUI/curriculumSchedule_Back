package com.xjtu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjtu.entity.ClassInfoByClass;

public interface ClassInfoByClassDao {
	 /**
     * 添加班级课程进入数据库
     * @param classInfoByCourse
     * @return 返回受影响行数
     */
    int insertClass(ClassInfoByClass classInfoByClass);

    /**
     * 查询数据库 并且携带课程实体
     * @param term
     * @param classname
     * @return
     */
    List<ClassInfoByClass> queryByKeyWithClass(@Param("term") String term, @Param("classname") String classname);
}


