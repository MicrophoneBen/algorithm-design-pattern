package com.other.updown.exception;

import lombok.Data;

/**
 * @author :wuyuhao
 * @version: 2019-2-26
 * @since
 */
@Data
public class AccessException extends RuntimeException {

    private int code;
    private String message;

    /**
     * 错误构造类
     * @param errorCode
     */
    public AccessException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 错误构造类
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public AccessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
