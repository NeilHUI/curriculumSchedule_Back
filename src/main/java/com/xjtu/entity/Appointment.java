package com.xjtu.entity;

import java.util.Date;

/**
 * Created by llh.xjtu on 17-4-23.
 * 预约图书实体
 */
public class Appointment {
    private long bookId;

    private long studentId;

    private Date appointTime;

    //多对一的符合属性
    private Book book;

    public Appointment() {
    }

    public Appointment(long bookId, long studentId, Date appointTime) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
    }

    public Appointment(long bookId, long studentId, Date appointTime, Book book) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
        this.book = book;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }
}
