package com.yst.common.utils;

import com.yst.common.bean.SessionUser;
import com.yst.common.constats.GlobConts;

/**
 * Dky工具类
 * Created by wangpeng on 2017/1/6.
 */
public class DkyUtils {

    /**
     * 加入到登陆用户到当前线程
     * @param sessionUser
     */
    public static void putCurrentUser(SessionUser sessionUser){
        ThreadLocalUtils.put(GlobConts.CURRENT_SESSION_KEY,sessionUser);
    }

    public static void putCurrentToken(String token){
        ThreadLocalUtils.put(GlobConts.CURRENT_TOKEN_KEY,token);
    }

    public static String getCuurentToken(){
        return ThreadLocalUtils.getString(GlobConts.CURRENT_TOKEN_KEY);
    }

    /**
     * 获取当前登陆用户
     * @return
     */
    public static SessionUser getCurrentUser(){
        return (SessionUser) ThreadLocalUtils.getObj(GlobConts.CURRENT_SESSION_KEY);
    }
}
