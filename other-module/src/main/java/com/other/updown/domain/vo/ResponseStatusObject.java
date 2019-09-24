package com.other.updown.domain.vo;

import lombok.Data;

/**
 * @author zhangbingquan
 * @desc 响应状态对象
 * @time 2019-09-24 23:20
 */
@Data
public class ResponseStatusObject {
    private static final long serialVersionUID = 2015789671965355455L;
    public static final String yyyyMMddHHmmss_style = "yyyyMMddHHmmss";
    private String requestURL;
    private Integer statusCode;
    private String statusString;
    private String id;
    private String localTime;
    private String singInfo;

    public ResponseStatusObject() {
    }

    public ResponseStatusObject(int statusCode, String statusString) {
        this.statusCode = statusCode;
        this.statusString = statusString;
    }

    public ResponseStatusObject(String requestURL, int statusCode, String statusString, String id) {
        this.requestURL = requestURL;
        this.statusCode = statusCode;
        this.statusString = statusString;
        this.id = id;
        this.localTime = "";
    }
}
