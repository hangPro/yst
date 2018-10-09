package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum IsActiveEnum {

    YES("Y","是"),
    NO("N","否"),
    ;

    IsActiveEnum() {
    }

    IsActiveEnum(String code, String message) {
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
