package com.xjtu.web;

import com.xjtu.dto.AppointmentExecution;
import com.xjtu.dto.Result;
import com.xjtu.entity.Book;
import com.xjtu.enums.AppointStateEnum;
import com.xjtu.exception.NoNumberException;
import com.xjtu.exception.RepeaterAppointException;
import com.xjtu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-23.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model){
        List<Book> list  = bookService.getList();
        model.addAttribute("list", list);
        return "list";
    }
    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.POST)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if(bookId == null){
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if(book == null){
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";

    }

    @ResponseBody
    @RequestMapping(value = "/{bookId}/appoint",method = RequestMethod.POST,
            produces = {"application/json; charset=utf-8"})
    private Result<AppointmentExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId")Long studentId){
        if (studentId == null || studentId.equals("")){
            return new Result<>(false,"学号不能为空");
        }
        AppointmentExecution execution = null;
        execution = bookService.appoint(bookId,studentId);


        if (studentId == null || studentId.equals("")) {
            return new Result<>(false, "学号不能为空");
        }

        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointmentExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeaterAppointException e2) {
            execution = new AppointmentExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointmentExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointmentExecution>(true,execution);
    }
}
