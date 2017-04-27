package com.xjtu.exception;

/**
 * Created by llh.xjtu on 17-4-27.
 * 无本地数据时，抛出异常
 */
public class NoLocalDataException extends RuntimeException {
    public NoLocalDataException(String message) {
        super(message);
    }

    public NoLocalDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
