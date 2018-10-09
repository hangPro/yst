package com.yst.business.session;

import com.yst.business.cache.RedisCacheManager;
import com.yst.common.bean.SessionUser;
import com.yst.common.constats.GlobConts;
import com.yst.common.utils.CookieUtils;
import com.yst.common.utils.DkyStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by wangpeng on 2016/11/4.
 */
@Component
public class SessionProcess {

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 保存登陆cookie
     * @param user
     * @param response
     * @param timeout
     * @return
     */
    public String login(SessionUser user, HttpServletResponse response, Long timeout){
        if(user != null){
            String token = DkyStringUtils.uuidString();
            //存入redis
            redisCacheManager.put(token,user,timeout);
            String accessToken = GlobConts.COOKIE_PREFIX+token;
            int expiry = Long.valueOf(timeout.longValue() / 1000L).intValue();
            CookieUtils.setCookieHttpOnly(response, GlobConts.SESSION_COOKIE_KEY, accessToken, (String) null, "/", Integer.valueOf(expiry));
            return token;
        }else {
            return "";
        }
    }

    /**
     * 从cokkie中获取accessToke
     * @param request
     * @return
     */
    public String getAcessToken(HttpServletRequest request){
        String sessionInfo = CookieUtils.getCookie(request,GlobConts.SESSION_COOKIE_KEY);
        if(StringUtils.isNotEmpty(sessionInfo)){
            return sessionInfo.substring(GlobConts.COOKIE_PREFIX.length());
        }else {
            sessionInfo = request.getHeader(GlobConts.SESSION_COOKIE_KEY);
            return StringUtils.isNotEmpty(sessionInfo) ? sessionInfo.substring(GlobConts.COOKIE_PREFIX.length()):request.getParameter("accessToken");
        }
    }

    public SessionUser getSessionUser(String accessToken){
        if(StringUtils.isEmpty(accessToken)){
            return null;
        }
        return (SessionUser)redisCacheManager.get(accessToken);
    }

    /**
     * 注销
     * @param request
     * @return
     */
    public void logout(HttpServletRequest request){
        String accessToken = getAcessToken(request);
        if(StringUtils.isEmpty(accessToken)){
            return;
        }
        redisCacheManager.delete(accessToken);
    }
}
