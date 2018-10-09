package com.yst.web.aspect;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * 用户会话切面
 * Created by wangpeng on 2016/11/7.
 */
@Aspect
@Component
public class LogAspect implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    private static final String HTTP_SERVLET_RESPONSE = "javax.servlet.http.HttpServletResponse";
    private static final String HTTP_SERVLET_REQUEST = "javax.servlet.http.HttpServletRequest";
    private static final String HTTP_JETTY_REQUEST = "org.eclipse.jetty.server.Request";
    private static final String ValidatorException = "ValidatorException";
    public static final String FORMAT_KV = "kv";
    public static final String FORMAT_JSON = "json";

    //对象日志输出格式
    private String format = FORMAT_KV;

    @Pointcut("execution(* com.yst.web.controller..*.*(..))")
    private void aspectjMethod() {
    }

    @Around("aspectjMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{

        logBeforeSafe(pjp);
        Object result = null;
        try {
            result = pjp.proceed();
        } finally {
            logAfterSafe(pjp, result);
        }
        return result;
    }

    @Before("aspectjMethod()")
    public void before(JoinPoint joinPoint) throws Throwable{
        // 接收到请求，记录请求内容
    }

    /**
     * AfterReturning 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     * @author hang
     * @param joinPoint
     */
    @AfterReturning(value = "aspectjMethod()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, String retVal) {
        // todo something
        System.out.println("<<<<<<<<<<<<<"+retVal);
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     *
     * 注意：执行顺序在Around Advice之后
     * @author lyl
     * @param joinPoint
     * @param e
     * @throws ClassNotFoundException
     */
    @AfterThrowing(value = "aspectjMethod()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException {
        System.out.println(e.getMessage());
    }

        @Override
    public int getOrder() {
        return 1;
    }

    private void logBefore(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        MethodSignature methodSignature= (MethodSignature) pjp.getSignature();
        String[] paramNames = methodSignature.getParameterNames();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if(paramNames != null && paramNames.length > 0) {
            for (int i = 0; i < paramNames.length; i++) {
                if (i < args.length && paramNames[i] != null && args[i] != null) {
                    String paramName = paramNames[i];
                    if (args[i].getClass().getName().equals(HTTP_SERVLET_RESPONSE)) {
                        continue;
                    }
                    if (args[i].getClass().getName().equals(HTTP_SERVLET_REQUEST)) {
                        continue;
                    }
                    if (args[i].getClass().getName().equals(ValidatorException)) {
                        continue;
                    }
                    if (args[i].getClass().getName().equals(HTTP_JETTY_REQUEST)) {
                        continue;
                    }
                    paramMap.put(paramName, args[i]);
                }
            }
        }
        String methodName = pjp.getTarget().getClass().getSimpleName()+ "." +methodSignature.getMethod().getName();
        log(methodName, PrintUtils.printObjectData(paramMap));
    }

    private void logAfterSafe(ProceedingJoinPoint pjp, Object result) {
        try {
            logAfter(pjp, result);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void logAfter(ProceedingJoinPoint pjp, Object result) {
        MethodSignature methodSignature= (MethodSignature) pjp.getSignature();
        String methodName = pjp.getTarget().getClass().getSimpleName()+ "." +methodSignature.getMethod().getName();
        log(methodName, result);
    }

    private void logBeforeSafe(ProceedingJoinPoint pjp) {
        try {
            logBefore(pjp);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void log( String methodName, Object data) {
        if (FORMAT_JSON.equals(format)) {
            LOGGER.info(methodName+" "+ JSON.toJSONString(data));
        }
        else if (FORMAT_KV.equals(format)) {
            LOGGER.info(methodName+" "+ PrintUtils.printObjectData(data));
        }
        else {
            LOGGER.info(methodName+" "+ PrintUtils.printObjectData(data));
        }
    }
}
