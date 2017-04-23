package com.xjtu.service.impl;

import com.xjtu.BaseTest;
import com.xjtu.dto.AppointmentExecution;
import com.xjtu.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by llh.xjtu on 17-4-23.
 */
public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;
    @Test
    public void getById() throws Exception {
        long bookId = 1001;
        System.out.println(bookService.getById(bookId));
    }

    @Test
    public void getList() throws Exception {
    }

    @Test
    public void appoint() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        AppointmentExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

}