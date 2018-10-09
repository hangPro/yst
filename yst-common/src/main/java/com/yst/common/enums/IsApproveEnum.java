package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum IsApproveEnum {
    DEFAULT(1,"待审核"),
    APPROVE_SUCCESS(2,"审核通过"),
    APPROVE_FAIL(-1,"审核不通过"),
    ;

    IsApproveEnum() {
    }

    IsApproveEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
