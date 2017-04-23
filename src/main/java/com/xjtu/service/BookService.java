package com.xjtu.service;

import com.xjtu.dto.AppointmentExecution;
import com.xjtu.entity.Book;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-23.
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface BookService {
    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> getList();

    /**
     * 预约图书
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointmentExecution appoint(long bookId, long studentId);
}
