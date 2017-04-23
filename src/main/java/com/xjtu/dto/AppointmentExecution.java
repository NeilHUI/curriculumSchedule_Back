package com.xjtu.dto;

import com.xjtu.entity.Appointment;
import com.xjtu.enums.AppointStateEnum;

/**
 * Created by llh.xjtu on 17-4-23.
 * 封装预约执行后结果
 */
public class AppointmentExecution {
    private long bookId;

    private int state;

    private String stateInfo;

    private Appointment appointment;

    public AppointmentExecution() {
    }

    //预约失败的构造器
    public AppointmentExecution(long bookId, AppointStateEnum appointStateEnum) {
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
    }

    //预约成功的构造器
    public AppointmentExecution(long bookId, AppointStateEnum appointStateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = appointStateEnum.getState();
        this.stateInfo = appointStateEnum.getStateInfo();
        this.appointment = appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointmentExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
