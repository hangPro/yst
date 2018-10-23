package com.yst.common.param;

import com.yst.common.session.BaseParameter;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by hang on 2017/1/4 0004.
 */
public class LoginUserParam extends BaseParameter {

    private static final long serialVersionUID = 1L;
    /**
     * 登录邮箱
     */
    @NotEmpty(message = "登录用户名不能为空")
    private String userName;
    /**
     * 登录密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
