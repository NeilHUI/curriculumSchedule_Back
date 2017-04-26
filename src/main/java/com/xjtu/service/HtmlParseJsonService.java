package com.xjtu.service;

import com.xjtu.entity.ClassInfoByCourse;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-26.
 */
public interface HtmlParseJsonService {


    /**
     * 获取格式一的数据---------教师课表
     *
     * @param fileName
     * @return
     */
    JSONObject getClassInfo1(String fileName);


    /**
     * 获取格式一的数据---------课程课表
     *
     * @param fileName
     * @return
     */
    List<ClassInfoByCourse> getClassInfo2(String fileName);


    /**
     * 获取格式一的数据---------教室课表
     *
     * @param fileName
     * @return
     */
    JSONObject getClassInfo3(String fileName);


    /**
     * 获取格式一的数据---------任选课表
     *
     * @param fileName
     * @return
     */
    JSONObject getClassInfo4(String fileName);


    /**
     * 下拉列表的html解析转成list
     *
     * @param html
     * @return
     */
    Map<String, String> optiontoList(String html);
}
