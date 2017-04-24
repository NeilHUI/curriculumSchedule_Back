package com.xjtu.web;

import com.xjtu.enums.ListInfoStateEnum;
import com.xjtu.service.ClassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-25.
 */
@Controller
@RequestMapping("/schedule")
public class QueryScheduleController {
    private Logger logger = LoggerFactory.getLogger(QueryScheduleController.class);

    @Autowired
    private ClassInfoService classInfoService;


    @ResponseBody
    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    private Map<String, String> courseList(@RequestParam("term") String term){
        return classInfoService.queryList(term, ListInfoStateEnum.COURSE_TYPE.getState());
    }

}
