package com.yst.web.interceptor;


import com.yst.business.cache.RedisCacheManager;
import com.yst.common.exception.RequestLimitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问拦截器
 * Created by hang on 2017/1/10.
 */
public class URLInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(URLInterceptor.class);

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //urlHandle(request,5000,20);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        String ip = request.getLocalAddr();
        //urlHandle(request,10000,5);
//        List<Blacklist> blackList =blacklistDao.findByIp(ip);
//        if(blackList==null || blackList.size()==0){
//            urlHandle(request,10000,10);
//        }else{
//            modelAndView.setViewName("/errorpage/error");
//        }
    }

    public void urlHandle(HttpServletRequest request, long limitTime,int limitCount) throws RequestLimitException {
        try{
            String ip = request.getLocalAddr();
            String url = request.getRequestURL().toString();
            final String key = "req_limit_".concat(url).concat(ip);
            if(redisCacheManager.getInt(key)==null || redisCacheManager.getInt(key)==0){
                redisCacheManager.put(key,1,limitTime);
            }else{
                redisCacheManager.put(key,redisCacheManager.getInt(key)+1,redisCacheManager.getExpire(key));
            }
            int count = redisCacheManager.getInt(key);
//            if (count > 0) {
//                Timer timer= new Timer();
//                TimerTask task  = new TimerTask(){
//                    @Override
//                    public void run() {
//                        redisCacheManager.delete(key);
//                    }
//                };
//                timer.schedule(task, limitTime);
//            }
            if (count > limitCount) {
                //addHostHandle(ip);
                throw new RequestLimitException("访问过于频繁，拉入黑名单！");
            }
        } catch (RequestLimitException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error("发生异常: ", e);
        }
    }

//    public void addHostHandle(String ip){
//        Blacklist blacklist=new Blacklist(ip,iptime);
//        blacklistDao.save(blacklist);
//    }
}
