package com.xjtu.exception;

/**
 * Created by llh.xjtu on 17-4-26.
 * 验证码错误异常
 */
public class VerificationException extends RuntimeException{
    public VerificationException(String message) {
        super(message);
    }

    public VerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
