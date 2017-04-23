package com.xjtu.dao;

import com.xjtu.entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by llh.xjtu on 17-4-23.
 */
public interface AppointmentDao {

    /**
     * 预定图书
     *
     * @param bookId
     * @param studentId
     * @return 预定成功返回大于零的数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键即bookId和studentId来查询预约图书记录，并且携带图书实体
     *
     * @param bookId
     * @param studentId
     * @return 返回携带图书实体
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
