package com.algorithm.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangbingquan
 * @desc 线性表插入异常
 * @time 2019/7/20 19:30
 */
@Getter
@Setter
public class InsertException extends RuntimeException {
    private Integer code;
    private String message;

    public InsertException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public InsertException(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
