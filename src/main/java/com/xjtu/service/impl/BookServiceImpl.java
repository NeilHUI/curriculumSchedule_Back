package com.xjtu.service.impl;

import com.xjtu.dao.AppointmentDao;
import com.xjtu.dao.BookDao;
import com.xjtu.dto.AppointmentExecution;
import com.xjtu.entity.Appointment;
import com.xjtu.entity.Book;
import com.xjtu.enums.AppointStateEnum;
import com.xjtu.exception.AppointException;
import com.xjtu.exception.NoNumberException;
import com.xjtu.exception.RepeaterAppointException;
import com.xjtu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by llh.xjtu on 17-4-23.
 */
@Service
public class BookServiceImpl implements BookService{

    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAllBook(0,20);
    }

    @Override
    @Transactional
    public AppointmentExecution appoint(long bookId, long studentId) {
        //减库存
        int update = bookDao.reduceNumber(bookId);
        try {
            if (update<=0){
                //库存不足
                return new AppointmentExecution(bookId, AppointStateEnum.NO_NUMBER);
            } else {
                //执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {
                    //重复秒杀
                    return new AppointmentExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
                } else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointmentExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }


            }
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeaterAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new AppointException("appoint inner error :"+e.getMessage());
        }

    }
}
