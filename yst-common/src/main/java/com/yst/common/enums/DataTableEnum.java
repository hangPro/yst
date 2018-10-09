package com.yst.common.enums;

/**
 * Created by hang on 2017/1/4.
 */
public enum DataTableEnum {
    MPTBELONGTYPE("MPTBELONGTYPE","MPTBELONGTYPESUM"),//所属类别
    DIMFLAG_NEW14("DIMFLAG_NEW14","PZSUM"),//品种
    DIMFLAG_16("DIMFLAG_16","PLSUM"),//品类
    DIMFLAG_13("DIMFLAG_13","XLSUM"),//系列
    DIMFLAG_NEW13("DIMFLAG_NEW13","XBSUM"),//性别
    DIMFLAG_14("DIMFLAG_14","BDSUM"),//波段
    DIMFLAG_NEW16("DIMFLAG_NEW16","ZXSUM"),//针型
    ;

    DataTableEnum() {
    }

    DataTableEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static DataTableEnum getByCode(String code){
        for (DataTableEnum type : values()) {
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
