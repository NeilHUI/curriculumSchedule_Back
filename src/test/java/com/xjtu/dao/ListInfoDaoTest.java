package com.xjtu.dao;


import com.xjtu.BaseTest;
import com.xjtu.entity.ListInfo;
import com.xjtu.enums.ListInfoStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by llh.xjtu on 17-4-25.
 */
public class ListInfoDaoTest extends BaseTest {

    @Autowired
    private ListInfoDao listInfoDao;

    @Autowired
    private ListInfo listInfo;

    @Test
    public void insertCourseList() throws Exception {
        listInfo.setTerm("setTerm");
        listInfo.setListContent("setListContent");
        listInfo.setType(ListInfoStateEnum.COURSE_TYPE.getState());
        listInfoDao.insertCourseList(listInfo);
    }

    @Test
    public void queryAllList() throws Exception {
        List<ListInfo> lists = new ArrayList<>();
        lists = listInfoDao.queryAllList("setTerm",ListInfoStateEnum.COURSE_TYPE.getState());
        System.out.println(lists);
    }

}