package com.xjtu.dao;

import com.xjtu.entity.Book;
import com.xjtu.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-23.
 */
public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void queryById() throws Exception {
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void queryAllBook() throws Exception {
        List<Book> books = bookDao.queryAllBook(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update=" + update);
    }

}