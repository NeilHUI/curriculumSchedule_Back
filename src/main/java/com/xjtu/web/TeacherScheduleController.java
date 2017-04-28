package com.xjtu.web;

import com.xjtu.dto.Result;
import com.xjtu.entity.ClassInfoByTeacher;
import com.xjtu.entity.ListResult;
import com.xjtu.enums.ListInfoStateEnum;
import com.xjtu.exception.NoLocalDataException;
import com.xjtu.exception.VerificationException;
import com.xjtu.service.ClassInfoService;
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
 * Created by llh.xjtu on 17-4-28.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherScheduleController {

    private Logger logger = LoggerFactory.getLogger(QueryScheduleController.class);


    @Autowired
    private ClassInfoService classInfoService;



    /**
     * /schedule/{term}/teacherList
     * 访问教师列表
     * @param term 学期id
     * @return 教师列表json
     */
    @ResponseBody
    @RequestMapping(value = "/{term}/teacherList", method = RequestMethod.GET)
    private List<ListResult> teacherList(@PathVariable("term") String term) {
        return classInfoService.queryList(term, ListInfoStateEnum.TEACHER_TYPE.getState());
    }


    @ResponseBody
    @RequestMapping(value = "/queryClassByTeacher",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    private Result<List<ClassInfoByTeacher>> queryClassByTeacher(@RequestBody Map<String, String> obj) {
        List<ClassInfoByTeacher> listResult = new ArrayList<>();
        String term = obj.get("term");
        String teacher = obj.get("teacher");
        String yzm = obj.get("yzm");
        /*if(yzm.equals("")){
            return new Result<>(false,"验证码为空");
        }*/
        try {
            listResult = classInfoService.queryByTeacher(term, teacher, yzm);
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
        return new Result<List<ClassInfoByTeacher>>(true, listResult);
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
