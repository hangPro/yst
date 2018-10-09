package com.yst.common.exception;

/**
 * Created by wangpeng on 2017/1/10.
 */
public class NoLoginException extends RuntimeException {

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException() {
    }
}
