package com.yst.common.enums;

/**
 * Created by wonpera on 2017/1/4.
 */
public enum FlagEnum {
    ZZFLAG("2","组织"),
    ZXFLAG("3","针型"),
    ZBFLAG("4","支别"),
    ;

    FlagEnum() {
    }

    FlagEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
