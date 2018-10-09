package com.yst.business.biz.impl;

import com.yst.business.biz.UserService;
import com.yst.business.repository.UsersMapper;
import com.yst.common.bean.Users;
import com.yst.common.enums.ResultCodeEnum;
import com.yst.common.param.LoginUserParam;
import com.yst.common.response.ReturnT;
import com.yst.common.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hang on 2017/1/4 0004.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public ReturnT loginUser(LoginUserParam param) {
        ReturnT result = new ReturnT<>();
        Users users = usersMapper.selectByUsername(param.getUsername());
        if (users == null || !users.getPassword().equals(Base64Util.encodeHanfuPassWord(param.getPassword()))){
            return result.failureData(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        result.setData(users);
        return result.successDefault();
    }
}
