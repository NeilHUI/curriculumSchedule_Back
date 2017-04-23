package com.xjtu.exception;

/**
 * Created by llh.xjtu on 17-4-23.
 */
public class NoNumberException extends RuntimeException{
    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
