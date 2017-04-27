package com.xjtu.service;

import com.xjtu.entity.ClassInfoByCourse;
import com.xjtu.entity.ListResult;

import java.util.List;
import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-24.
 * <p>
 * 查询课程表的类
 */
public interface ClassInfoService {

    /**
     * 得到验证码id
     * @return string验证码id
     */
    String code();

    /**
     * 查询列表内容
     * @param term 学期
     * @param type 类型
     * @return 返回列表list
     */
    List<ListResult> queryList(String term, int type);

    /**
     * 通过课程查询课表
     *
     * @param term
     * @param course
     * @return
     */
    List<ClassInfoByCourse> queryByCourse(String term, String course, String yzm);


}
