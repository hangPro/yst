package com.yst.common.bean;

import java.io.Serializable;

/**
 * Created by wangpeng on 2017/1/4.
 */
public class SessionUser implements Serializable {

    private static final long serialVersionUID = -6736961910288444407L;

    private Long userId;

    private String username;

    private Integer userType;

    private Boolean isUser = Boolean.TRUE;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean user) {
        isUser = user;
    }
}
