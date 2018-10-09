package com.yst.common.enums;

/**
 * Created by wangpeng on 2017/1/10.
 */
public enum  DimFlagEnum {
    SEX("DIMFLAG_NEW13","性别"),
    BIG_CLASS("DIMFLAG_NEW11","大类"),
    PZ_FLAG("DIMFLAG_NEW14","品种"),
    ZZ_FLAG("DIMFLAG_NEW15","组织"),
    ZX_FLAG("DIMFLAG_NEW16","针型"),
    SY_FLAG("DIMFLAG_NEW12","式样"),
    LX_FLAG("DIMFLAG_NEW25","领型"),
    XX_FLAG("DIMFLAG_NEW9","袖型"),
    YEAR_FLAG("DIM13","年份"),
    PIN_FLAG("DIM16","品类"),
    ;


    private String code;

    private String message;

    DimFlagEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

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
