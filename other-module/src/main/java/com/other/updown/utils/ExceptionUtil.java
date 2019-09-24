package com.other.updown.utils;

import com.other.updown.exception.AccessException;
import com.other.updown.exception.ErrorCode;

/**
 * 错误抛出工具类
 *
 * @author huangyujie
 * @since 2019/4/23 10:32
 */
public class ExceptionUtil {

    /**
     * 参数校验错误
     * @param message
     */
    public static void fieldValidateError(String message){
        throw new AccessException(ErrorCode.ERROR.getCode(), message);
    }

    /**
     * 校验错误
     */
    public static void validateError(){
        throw new AccessException(ErrorCode.ERROR);
    }

    /**
     * 校验错误
     * @param message
     */
    public static void validateError(String message){
        throw new AccessException(ErrorCode.ERROR.getCode(), message);
    }

    /**
     * 抛出错误
     *
     * @param errorCode 指定错误码
     * @param message
     */
    public static void throwError(Integer errorCode, String message){
        throw new AccessException(errorCode, message);
    }

    /**
     * 系统错误
     */
    public static void unknownError(String message){
        throw new AccessException(ErrorCode.ERROR.getCode(), message);
    }

    public static void roleEmptyError(String message) {
        throw new AccessException(ErrorCode.ROLE_EMPTY_ERROR.getCode(), message);
    }
}
