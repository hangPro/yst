package com.yst.web.controller;

import com.yst.business.biz.UserService;
import com.yst.business.session.SessionProcess;
import com.yst.common.bean.SessionUser;
import com.yst.common.bean.Users;
import com.yst.common.param.LoginUserParam;
import com.yst.common.response.ReturnT;
import com.yst.common.utils.DkyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by hang on 2017/1/4 0004.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionProcess sessionProcess;

    @RequestMapping(value = "loginUser", name = "登录")
    public ReturnT loginUser(LoginUserParam param, HttpServletResponse response) {
        ReturnT returnT = userService.loginUser(param);
        if (!returnT.isSuccess()) {
            return returnT;
        }
        Object data = returnT.getData();
        SessionUser sessionUser = new SessionUser();
        if(data instanceof Users){
            Users users = (Users) data;
            sessionUser.setUserId(users.getId());
            sessionUser.setUsername(users.getUsername());
        }
        String token = sessionProcess.login(sessionUser, response, 60 * 60 * 24 * 7 * 1000L);
        return new ReturnT().sucessData(token);
    }


    /**
     * 获取当前登陆用户信息
     * @return
     */
    @RequestMapping(value = "getCurrentUser",name = "获取当前登陆用户")
    public ReturnT getCurrentUser(){
        SessionUser sessionUser = DkyUtils.getCurrentUser();//获取当前用户
        return new ReturnT().sucessData(sessionUser);
    }
}
