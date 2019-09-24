package com.other.updown.exception;

import javax.validation.ValidationException;

/**
 * @author zhangbingquan
 * @version 2019年09月21日
 * @since 2019年09月21日
 **/
public class ValidateErrorException extends ValidationException {
    private int code;
    private String message;

    /**
     * 错误构造类
     * @param errorCode
     */
    public ValidateErrorException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 错误构造类
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public ValidateErrorException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
