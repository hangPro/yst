package com.yst.common.utils;

import com.yst.common.exception.ValidatorException;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.Validation;
import java.util.Set;

/**
* Created by wangpeng on 2016/12/13.
*/
public class ValidatorUtils {

    private static Validator validator;

    static {
        init();
    }

    private static void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <T> void validator(T t)throws ValidatorException{
        Set violations = validator.validate(t, new Class[0]);
        if(!violations.isEmpty()){
            throw new ValidatorException(buildErrorMsg(violations));
        }
    }


    private static <T> String buildErrorMsg(Set<ConstraintViolation<T>> violations){
        StringBuilder sb = new StringBuilder();
        for(ConstraintViolation constraintViolation : violations){
            sb.append("[").append(constraintViolation.getMessage()).append("]").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
