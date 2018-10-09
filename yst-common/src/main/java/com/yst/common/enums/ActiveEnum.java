package com.yst.common.enums;

/**
 * Created by wonpera on 2017/1/4.
 */
public enum  ActiveEnum {
    ENABLE("Y","启用"),
    DISABLE("N","停用"),
    ;

    ActiveEnum() {
    }

    ActiveEnum(String code, String message) {
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
