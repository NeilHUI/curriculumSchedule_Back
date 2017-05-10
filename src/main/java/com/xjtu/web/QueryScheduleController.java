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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by llh.xjtu on 17-4-25.
 */
@Controller
@RequestMapping("/course")
public class QueryScheduleController {
    private Logger logger = LoggerFactory.getLogger(QueryScheduleController.class);


    @Autowired
    private ClassInfoService classInfoService;



    /**
     * 访问课程列表
     * @param term 学期
     * @return 课程列表json
     */
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
        /*if(yzm.equals("")){
            return new Result<>(false,"验证码为空");
        }*/
        try {
            listResult = classInfoService.queryByCourse(term, course, yzm);
            if (listResult.size() == 0){
                return new Result<>(false,"数据为空～T-T");
            }
        } catch (VerificationException e1) {
            return new Result<>(false,"验证码错误");
        } catch (NoLocalDataException e2) {
            //当无本地数据时，请求获取验证码
            //String codeId = classInfoService.code();
            return new Result<>(true,"无本地数据请输入验证码#");
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

    @ResponseBody
    @RequestMapping(value = "/getVerImg", method = RequestMethod.GET)
    private void getVerImg(HttpServletResponse response) throws IOException {

        response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        byte[] bytes = classInfoService.getVerImg();
        stream.write(bytes);
        stream.flush();
        stream.close();
    }


}
