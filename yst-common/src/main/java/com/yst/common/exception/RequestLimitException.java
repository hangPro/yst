package com.yst.common.exception;

/**
 * Created by wonpera on 2017/1/4.
 */
public class RequestLimitException extends RuntimeException {

    public RequestLimitException(String message) {
        super(message);
    }
}
