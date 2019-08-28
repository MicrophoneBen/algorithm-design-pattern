package com.algorithm.exception;

/**
 * @author zhangbingquan
 * @desc 全局异常类，异常类抛出Code、
 * @time 2019/7/20 19:40
 */
public enum ErrorCode {
    /**
     * 插入错误!
     */
    INPUT_ERROR(10001, "插入错误!"),

    /**
     * 删除错误!
     */
    FIELD_VALIDATE_ERROR(10002, "删除错误!"),

    /**
     * 查找错误!
     */
    UNKNOWN_ERROR(99999, "index错误!"),

    /**
     * 更新错误！
     */
    FILE_SIZE_ERROR(10003,"数据更新错误！"),

    /**
     * 内容修改失败
     */
    UPDATE_ERROR(10004,"修改失败！");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
