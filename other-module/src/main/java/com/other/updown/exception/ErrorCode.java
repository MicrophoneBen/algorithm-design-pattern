package com.other.updown.exception;

/**
 * @author :wuyuhao
 * @version: 2019-2-26
 * @since
 */
public enum ErrorCode {

    /**
     * 输入错误!
     */
    ERROR(3, "错误!"),

    /**
     * 输入错误!
     */
    INPUT_ERROR(10001, "输入错误!"),

    /**
     * 格式错误!
     */
    FIELD_VALIDATE_ERROR(10002, "格式错误!"),

    /**
     * 系统错误!
     */
    UNKNOWN_ERROR(99999, "系统错误!"),

    /**
     * 文件大小超过上传限制错误！
     */
    FILE_SIZE_ERROR(10003, "文件大小超过上传限制错误!"),

    /**
     * 内容修改失败
     */
    UPDATE_ERROR(10004, "修改失败!"),

    /**
     * 校验失败!
     */
    VALIDATE_ERROR(30000, "校验失败!"),

    ROLE_EMPTY_ERROR(30001, "用户没有关联角色!"),

    FUNCTION_NOT_SUPPORT(40001, "暂不支持此功能!"),

    DUPLICATEKEY_ERROR(10005, "主键冲突，已存在相关数据!");


    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取类型
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /** 获取信息 */
    public String getMessage() {
        return message;
    }

}
