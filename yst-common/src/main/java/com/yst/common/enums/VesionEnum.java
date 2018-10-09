package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum VesionEnum {
    INNER_ORDER("1.0.0","订货会内网版本"),
    OUTER_ORDER("2.0.0","订货会外网版本"),
    JM_ORDER("3.0.0","加盟店版本"),
    ZM_ORDER("4.0.0","专卖店版本"),
    ;

    VesionEnum() {
    }

    VesionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static VesionEnum getByCodePage(String code){
        for (VesionEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
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
