package com.other.updown.constant.enums;

import lombok.Data;

/**
 * @author zhangbingquan
 * @desc 响应码枚举类
 * @time 2019-09-24 23:23
 */
public enum  StatusCodeEnum {
    SUCCESS(0, "成功");

    private int statusCode;
    private String statusDes;

    private StatusCodeEnum(int statusCode, String statusDes) {
        this.statusCode = statusCode;
        this.statusDes = statusDes;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusDes() {
        return this.statusDes;
    }
}
