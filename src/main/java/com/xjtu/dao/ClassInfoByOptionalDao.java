package com.xjtu.dao;

import com.xjtu.entity.ClassInfoByCourse;
import com.xjtu.entity.ClassInfoByOptional;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-24.
 * 任选课
 */
public interface ClassInfoByOptionalDao {
    /**
     * 添加课程进入数据库
     * @param classInfoByOptional
     * @return 返回受影响行数
     */
    int insertCourse(ClassInfoByOptional classInfoByOptional);

    /**
     * 查询数据库 并且携带课程实体
     * @param term
     * @param school
     * @return
     */
    List<ClassInfoByOptional> queryByKeyWithOptional(@Param("term") String term, @Param("school") String school);
}
