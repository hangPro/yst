package com.yst.web.aspect;


import com.yst.common.bean.SessionUser;
import com.yst.common.session.SessionParameter;
import com.yst.common.session.WebPageParameter;
import com.yst.common.utils.DkyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 用户会话切面
 * Created by wangpeng on 2016/11/7.
 */
@Aspect
@Component
public class SessionAspect implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionAspect.class);

    @Around("execution(* com.yst.web.controller..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(requestAttributes == null) {
            return pjp.proceed();
        }
        for (int i = 0; i< args.length;i++){//请求参数
            Object arg = args[i];
            if(arg instanceof SessionParameter){
                String accessToken = DkyUtils.getCuurentToken();
                SessionUser user = DkyUtils.getCurrentUser();
                SessionParameter sessionParameter = (SessionParameter)arg;
                sessionParameter.setAccessToken(accessToken);
                sessionParameter.setSessionUser(user);
            }
            if(arg instanceof WebPageParameter){//分页
                WebPageParameter webPageParameter = (WebPageParameter)arg;
                //计算分页起始行数
                webPageParameter.calculatePageLimit();
            }
        }
        return pjp.proceed();
    }



    @Override
    public int getOrder() {
        return 1;
    }
}
