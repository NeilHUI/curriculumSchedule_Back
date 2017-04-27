package com.xjtu.web;

import com.xjtu.dto.Result;
import com.xjtu.entity.ClassInfoByCourse;
import com.xjtu.entity.ListResult;
import com.xjtu.enums.ListInfoStateEnum;
import com.xjtu.exception.NoLocalDataException;
import com.xjtu.exception.VerificationException;
import com.xjtu.service.ClassInfoService;
import com.xjtu.service.UrlDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private UrlDataService urlData;


    @ResponseBody
    @RequestMapping(value = "/{term}/courseList", method = RequestMethod.GET)
    private List<ListResult> courseList(@PathVariable("term") String term) {
        return classInfoService.queryList(term, ListInfoStateEnum.COURSE_TYPE.getState());
    }


    @ResponseBody
    @RequestMapping(value = "/queryClassByCourse",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    private Result<List<ClassInfoByCourse>> queryClassByCourse(@RequestBody Map<String, String> obj) {
        List<ClassInfoByCourse> listResult = new ArrayList<>();
        String term = obj.get("term");
        String course = obj.get("course");
        String yzm = obj.get("yzm");
        if(yzm.equals("")){
            return new Result<>(false,"验证码为空");
        }
        try {
            listResult = classInfoService.queryByCourse(term, course, yzm);
        } catch (VerificationException e1) {
            return new Result<>(false,"验证码错误");
        } catch (NoLocalDataException e2) {
            //当无本地数据时，请求获取验证码
            String codeId = classInfoService.code();
            return new Result<>(false,"无本地数据请输入验证码#"+codeId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj.keySet());
        return new Result<List<ClassInfoByCourse>>(true, listResult);
    }

    @ResponseBody
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    private String code() {


        return classInfoService.code();

    }


}
