package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum SourceEnum {
    DEFALUT(1,"单品下单"),
    DISPLAY(2,"套系下单"),
    WITH(3,"套系下单"),
    ;

    SourceEnum() {
    }

    SourceEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static SourceEnum getByCode(Integer code){
        for (SourceEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
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
