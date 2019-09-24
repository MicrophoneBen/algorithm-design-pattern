package com.other.updown.domain.vo;

import com.other.updown.constant.enums.StatusCodeEnum;

/**
 * @author zhangbingquan
 * @desc 响应体
 * @time 2019-09-24 23:19
 */
public class Response<R> {
    private ResponseStatusObject responseStatusObject = new ResponseStatusObject();
    private R responseResult;

    public Response() {
        this.responseStatusObject.setStatusCode(StatusCodeEnum.SUCCESS.getStatusCode());
        this.responseStatusObject.setStatusString(StatusCodeEnum.SUCCESS.getStatusDes());
    }

    public Response(int code, String message) {
        this.responseStatusObject.setStatusCode(code);
        this.responseStatusObject.setStatusString(message);
    }

    public ResponseStatusObject getResponseStatusObject() {
        return this.responseStatusObject;
    }

    public void setResponseStatusObject(ResponseStatusObject responseStatusObject) {
    }

    public R getResponseResult() {
        return this.responseResult;
    }

    public void setResponseResult(R responseResult) {
        this.responseResult = responseResult;
    }
}