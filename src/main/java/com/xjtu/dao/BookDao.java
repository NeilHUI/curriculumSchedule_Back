package com.xjtu.dao;

import com.xjtu.entity.Book;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by llh.xjtu on 17-4-23.
 */
public interface BookDao {

    /**
     * 通过图书id查询
     *
     * @param bookId
     * @return
     */
    Book queryById(long bookId);

    /**
     * 查询所有的图书
     *
     * @return
     */
    List<Book> queryAllBook(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);
}
