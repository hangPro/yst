package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum IsCollectEnum {

    YES("2","是",Boolean.TRUE),
    NO("1","否",Boolean.FALSE),
    ;

    IsCollectEnum() {
    }

    IsCollectEnum(String code, String message,Boolean isCollect) {
        this.code = code;
        this.message = message;
        this.isCollect = isCollect;
    }

    public static IsCollectEnum getByCode(String code){
        for (IsCollectEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
    private String code;

    private String message;

    private Boolean isCollect;

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

    public Boolean getCollect() {
        return isCollect;
    }

    public void setCollect(Boolean collect) {
        isCollect = collect;
    }
}
