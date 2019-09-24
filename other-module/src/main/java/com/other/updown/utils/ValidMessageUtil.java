package com.other.updown.utils;

import com.other.updown.exception.ErrorCode;
import com.other.updown.exception.ValidateErrorException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

/**
 * @author zhangbingquan
 * @version 2019年09月21日
 * @since 2019年09月21日
 **/
@Slf4j
public class ValidMessageUtil {

    public static void validMessageHandler(BindingResult bindingResult) {
        if (null != bindingResult) {
            //获取校验错误信息
            if (bindingResult.hasErrors()) {
                //输出错误信息
                List<ObjectError> allErrors = bindingResult.getAllErrors();
                String errMsg = "";
                for (ObjectError objectError : allErrors) {
                    //输出
                    errMsg = objectError.getDefaultMessage();
                    log.error(errMsg);
                }
                throw new ValidateErrorException(ErrorCode.VALIDATE_ERROR.getCode(), errMsg);
            }
        }
    }
    
    public static void validateParams(Object obj , Class<?>... groups) {
        //调用JSR303验证工具，校验参数
        Validator validator = Validation.byProvider(HibernateValidator.class).configure()
                .addProperty("hibernate.validator.fail_fast", "false").buildValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(obj, groups);
        Iterator<ConstraintViolation<Object>> iter = violations.iterator();
        List<String> errMsgList = new ArrayList<>();
        Set<Object> rootBeanSet = new HashSet<>();
        while (true) {
            if (iter.hasNext()) {
                ConstraintViolation<Object> constraintViolation = iter.next();
                errMsgList.add(constraintViolation.getMessage());
                rootBeanSet.add(constraintViolation.getRootBean());
            }else {
                break;
            }
        }
        throw new ValidateErrorException(ErrorCode.VALIDATE_ERROR.getCode(), errMsgList.toString());
    }

    public static<V> List<V> validatePlatformParams(List<V> vList, Class... groups) {
        List<V> validFailList = new ArrayList<>();
        //调用JSR303验证工具，校验参数
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        for (V v : vList) {
            Set<ConstraintViolation<V>> violations = validator.validate(v, groups);
            for (ConstraintViolation<V> constraintViolation : violations) {
                validFailList.add(constraintViolation.getRootBean());
                //校验失败原因
                log.error(constraintViolation.getMessage());
            }
        }
        return validFailList;
    }
}
