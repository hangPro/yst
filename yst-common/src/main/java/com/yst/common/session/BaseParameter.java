package com.yst.common.session;

import java.io.Serializable;

/**
 * Created by wangpeng on 2016/11/7.
 */
public class BaseParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 版本号
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
