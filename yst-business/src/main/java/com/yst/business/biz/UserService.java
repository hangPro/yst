package com.yst.business.biz;

import com.yst.common.param.LoginUserParam;
import com.yst.common.response.ReturnT;

/**
 * Created by hang on 2017/1/4 0004.
 */
public interface UserService {

    ReturnT loginUser(LoginUserParam param);

}
