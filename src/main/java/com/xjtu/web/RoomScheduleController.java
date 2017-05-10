package com.xjtu.web;

import com.xjtu.dto.Result;
import com.xjtu.entity.ClassInfoByClass;
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
 * Created by llh.xjtu on 17-5-1.
 */

@Controller
@RequestMapping("/room")
public class RoomScheduleController {
    private Logger logger = LoggerFactory.getLogger(RoomScheduleController.class);



    @Autowired
    private ClassInfoService classInfoService;


    /**
     * /schedule/{term}/classList
     * 访问教室列表
     * @param term 学期id
     * @return 教室列表json
     */
    @ResponseBody
    @RequestMapping(value = "/{term}/roomList", method = RequestMethod.GET)
    private List<ListResult> classList(@PathVariable("term") String term) {
        return classInfoService.queryList(term, ListInfoStateEnum.CLASS_TYPE.getState());
    }



    /**
     * 查询教室具体课程
     * @param obj 传入json文件，包括term room yzm
     * @return 返回list json的课表信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryClassByRoom",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    private Result<List<ClassInfoByClass>> queryClassByTeacher(@RequestBody Map<String, String> obj) {
        List<ClassInfoByClass> listResult = new ArrayList<>();
        String term = obj.get("term");
        String room = obj.get("room");
        String yzm = obj.get("yzm");
        /*if(yzm.equals("")){
            return new Result<>(false,"验证码为空");
        }*/
        try {
            listResult = classInfoService.queryByRoom(term, room, yzm);
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
        return new Result<List<ClassInfoByClass>>(true, listResult);
    }

    /**
     * 获取验证码
     * @param response
     * @throws IOException
     */
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
