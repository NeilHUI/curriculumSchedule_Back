package com.xjtu.dao;

import com.xjtu.entity.ListInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-24.
 */
public interface ListInfoDao {

    /**
     * 添加列表信息
     *
     * @param listInfo 课程列表类
     * @return 返回受影响的行数
     */
    int insertCourseList(ListInfo listInfo);

    /**
     * 查询列表
     *
     * @param term 学期
     * @return 返回课程列表
     */
    List<ListInfo> queryAllList(@Param("term") String term, @Param("type") int type);


    //安卓端实现
    //List<ListInfo> queryListBykey(@Param("term") String term, @Param("type") int type, @Param("key") String key);
}
