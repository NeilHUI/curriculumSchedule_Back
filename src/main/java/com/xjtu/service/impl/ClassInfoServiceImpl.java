package com.xjtu.service.impl;

import com.xjtu.dao.ClassInfoByCourseDao;
import com.xjtu.dao.ListInfoDao;
import com.xjtu.entity.ClassInfoByCourse;
import com.xjtu.entity.ListInfo;
import com.xjtu.service.ClassInfoService;
import com.xjtu.service.htmlParse.HtmlParseJson;
import com.xjtu.service.htmlParse.UrlData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-24.
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    private Logger logger = LoggerFactory.getLogger(ClassInfoService.class);

    @Autowired
    private ClassInfoByCourseDao classInfoByCourseDao;

    @Autowired
    private UrlData urlData;

    @Autowired
    private HtmlParseJson htmlParseJson;

    @Autowired
    private ListInfoDao listInfoDao;


    @Override
    public Map<String, String> queryList(String term, int type) {
        Map<String, String> map = new HashMap<>();
        List<ListInfo> lists = new ArrayList<>();
        lists = listInfoDao.queryAllList(term, type);
        if (lists.size() == 0) {
            urlData.GetCookie();
            urlData.GetImage(1);
            //本地list为空，访问网络
            //1得验证码 ，2得到list
            String string = urlData.GetXNXQKC(term, "");
            map = htmlParseJson.OptiontoList(string);
        } else {
            for (ListInfo listIn : lists) {
                map.put(listIn.getListContent(), listIn.getValue());
            }
        }

        return map;
    }

    @Override
    public List<ClassInfoByCourse> queryByCourse(String term, String course, String yzm) {
        List<ClassInfoByCourse> lists = new ArrayList<>();
        //查询本地数据库看是否有数据
        lists = classInfoByCourseDao.queryByKeyWithCourse(term, course);
        if (lists.size() != 0) {
            //本地数据有数据直接返回数据
            return lists;
        } else {
            //本地数据库无数据查找网络端，并返回
            String type = "1";
            String string = urlData.GetKBFBLessonSel(term, course, type, yzm);
            try {
                htmlParseJson.getClassInfo1(string);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return lists;

    }
}
