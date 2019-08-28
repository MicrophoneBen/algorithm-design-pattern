package com.algorithm.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangbingquan
 * @desc 删除异常
 * @time 2019/7/20 21:28
 */
@Getter
@Setter
public class DeleteException extends RuntimeException {
    private Integer code;
    private String message;

    public DeleteException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public DeleteException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
