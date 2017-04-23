package com.xjtu.exception;

/**
 * Created by llh.xjtu on 17-4-23.
 * 预约业务异常
 */
public class AppointException extends RuntimeException{
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
