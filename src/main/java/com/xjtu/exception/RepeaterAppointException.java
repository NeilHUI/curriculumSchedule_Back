package com.xjtu.exception;

/**
 * Created by llh.xjtu on 17-4-23.
 * 重复预定异常
 */
public class RepeaterAppointException extends RuntimeException{
    public RepeaterAppointException(String message) {
        super(message);
    }

    public RepeaterAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
