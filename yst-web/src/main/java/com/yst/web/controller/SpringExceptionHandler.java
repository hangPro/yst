package com.yst.web.controller;

import com.yst.common.bean.SessionUser;
import com.yst.common.enums.ResultCodeEnum;
import com.yst.common.exception.NoLoginException;
import com.yst.common.exception.RequestLimitException;
import com.yst.common.exception.ValidatorException;
import com.yst.common.response.ReturnT;
import com.yst.common.utils.DkyStringUtils;
import com.yst.common.utils.DkyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 统一异常处理
 * Created by wangpeng on 2017/1/6.
 */
@ControllerAdvice
public class SpringExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringExceptionHandler.class);

    /**
     * 统一校验异常处理
     * @param e
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(ValidatorException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ReturnT handleException(ValidatorException e, HttpServletRequest request, HttpServletResponse response)throws IOException{
        printLog(e,request,response);
        return new ReturnT().failureData(ResultCodeEnum.VALIDATOR_ERROR.getCode(),e.getMessage());
    }


    /**
     * 统一登录异常处理
     * @param e
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(NoLoginException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ReturnT handleException(NoLoginException e, HttpServletRequest request, HttpServletResponse response)throws IOException{
        printLog(e,request,response);
        return new ReturnT().failureData(ResultCodeEnum.NOLOGIN);
    }


    /**
     * 统一请求频繁异常处理
     * @param e
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(RequestLimitException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ReturnT handleException(RequestLimitException e, HttpServletRequest request, HttpServletResponse response)throws IOException{
        printLog(e,request,response);
        return new ReturnT().failureData(ResultCodeEnum.REQUEST_ERROR);
    }


    /**
     * 统一异常处理
     * @param e
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ReturnT handleException(Exception e, HttpServletRequest request, HttpServletResponse response)throws IOException{
        printLog(e,request,response);
        if (e instanceof UncategorizedSQLException){
            return new ReturnT().failureData(DkyStringUtils.getThrowableMsg(e.getMessage()));
        }
        return new ReturnT().failureData(ResultCodeEnum.SYSTEM_ERROR);
    }

    private void printLog(Exception e, HttpServletRequest request, HttpServletResponse response){
        SessionUser sessionUser = DkyUtils.getCurrentUser();//获取当前登陆
        e.printStackTrace();
        if(sessionUser != null){
            LOGGER.error("『授权』用户[{}]访问路径[{}],异常信息【{}】",sessionUser.getUsername(),request.getRequestURL(),e.getMessage());
        }else {
            LOGGER.error("访问路径[{}],错误[{}]",request.getRequestURL(),e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(new SQLException() instanceof SQLException);
    }
}
