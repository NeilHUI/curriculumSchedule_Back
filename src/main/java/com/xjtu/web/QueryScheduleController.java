package com.xjtu.web;

import com.xjtu.enums.ListInfoStateEnum;
import com.xjtu.service.ClassInfoService;
import com.xjtu.service.htmlParse.UrlData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-25.
 */
@Controller
@RequestMapping("/schedule")
public class QueryScheduleController {
    private Logger logger = LoggerFactory.getLogger(QueryScheduleController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private UrlData urlData;


    @ResponseBody
    @RequestMapping(value = "/courseList", method = RequestMethod.GET)
    private Map<String, String> courseList(@RequestParam("term") String term) {
        return classInfoService.queryList(term, ListInfoStateEnum.COURSE_TYPE.getState());
    }


    @ResponseBody
    @RequestMapping(value = "/queryClassByCourse", method = RequestMethod.GET)
    private String queryClassByCourse() {



        return classInfoService.code();
    }

    @ResponseBody
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    private String code() {
        urlData.GetCookie();
        urlData.GetImage(1);
        return classInfoService.code();
    }


}
