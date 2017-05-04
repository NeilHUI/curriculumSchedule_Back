package com.xjtu.service;

import com.xjtu.entity.*;

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
     *
     * @return string验证码id
     */
    String code();

    /**
     * 获取验证码
     *
     * @return
     */
    byte[] getVerImg();

    /**
     * 查询列表内容
     *
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


    /**
     * 通过教师查询课表
     *
     * @param term
     * @param teacher
     * @param yzm
     * @return
     */
    List<ClassInfoByTeacher> queryByTeacher(String term, String teacher, String yzm);

    /**
     * 通过教室查询课表
     *
     * @param term
     * @param room
     * @param yzm
     * @return
     */
    List<ClassInfoByClass> queryByRoom(String term, String room, String yzm);

    /**
     * 任意课表查询
     * @param term 学期
     * @param school 校区
     * @param yzm 验证码
     * @return
     */
    List<ClassInfoByOptional> queryByOptional(String term, String school, String yzm);



}
