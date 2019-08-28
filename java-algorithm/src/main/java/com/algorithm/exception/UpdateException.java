package com.algorithm.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangbingquan
 * @desc 更新异常类
 * @time 2019/7/20 21:30
 */
@Getter
@Setter
public class UpdateException extends RuntimeException {
    private Integer code;
    private String message;

    public UpdateException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public UpdateException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
