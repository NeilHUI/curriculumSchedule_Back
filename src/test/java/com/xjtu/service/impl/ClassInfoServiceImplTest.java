package com.xjtu.service.impl;

import com.xjtu.BaseTest;
import com.xjtu.service.ClassInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by llh.xjtu on 17-4-25.
 */
public class ClassInfoServiceImplTest extends BaseTest {
    @Autowired
    private ClassInfoService classInfoService;

    @Test
    public void queryList() throws Exception {
        Map<String,String> map = new HashMap<>();
        map = classInfoService.queryList("setTerm",1);
        for (String s : map.keySet()) {
            System.out.println(s+"--"+map.get(s));
        }
    }

    @Test
    public void queryByCourse() throws Exception {



    }

}