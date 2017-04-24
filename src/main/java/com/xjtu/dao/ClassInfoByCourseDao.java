package com.xjtu.dao;

import com.xjtu.entity.ClassInfoByCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-24.
 */
public interface ClassInfoByCourseDao {
    /**
     * 添加课程进入数据库
     * @param classInfoByCourse
     * @return
     */
    int insertCourse(ClassInfoByCourse classInfoByCourse);

    /**
     * 查询数据库 并且携带课程实体
     * @param term
     * @param course
     * @return
     */
    List<ClassInfoByCourse> queryByKeyWithCourse(@Param("term") String term, @Param("course") String course);
}
