package com.other.updown.constant;

public enum ResponseStatusType {
    /**
     * 请求已经成功
     */
    SUCCESS_200("成功", 200),

    /**
     * 请求已经创建了一项新的资源
     */
    CREATED_201("添加数据成功", 201),

    /**
     * 请求已确认，进入队列 （用于异步或服务调用链， 不保证幂等性）
     */
    ACCEPTED_202("请求已确认", 202),

    /**
     * 请求已经成功，但没有返回数据
     */
    NO_CONTENT_204("请求已经成功，但没有返回数据", 204),
    
    /**
     * 所请求资源位置已被永久移动（永久的重定向）301
     */
    MOVED_PERMANENTLY_301("永久重定向", 301),
    
    /**
     * 所请求资源应该通过该位置访问，但实际上该资源位于另一个位置
     */
    FOUND_302("找到", 302),
    
    /**
     * 请求消息构建不对（通常用于创建或更新一个资源时，其数据是不完整或不正确的）
     */
    BAD_REQUEST_400("坏请求,请求数据不正确或不完整", 400),
    
    /**
     * 请求需要用户认证后才能访问该资源
     */
    UNAUTHORIZED_401("未授权，需要用户认证后才能访问该资源", 401),
    
    /**
     * 服务器拒绝处理该请求(设备不支持所请求的功能)
     */
    FORBIDDEN_403("禁止，服务器拒绝处理该请求", 403),
    
    /**
     * 所请求的资源不存在
     */
    NOT_FOUND_404("找不到，请求的资源不存在", 404),
    
    /**
     * API不支持所请求的HTTP方法
     */
    METHOD_NOT_ALLOWED_405("方法不允许", 405),
    
    /**
     * 所执行的操作与内部状态或正在执行的过程冲突
     */
    CONFLICT_409("冲突", 409),
    
    /**
     * 发生了内部服务器错误
     */
    INTERNAL_SERVER_ERROR_500("内部服务器错误", 500),
    
    /**
     * 服务器是正常的，但 REST 服务不可用。这通常是因为客户请求太多引起的
     */
    SERVICE_UNAVAILABLE_503("服务不可用", 503);
    
    private String statusDes;//状态码描述
    private int statusCode;//状态码
    
    private ResponseStatusType(String statusDes, int statusCode) {
        this.statusCode = statusCode;
        this.statusDes = statusDes;
    }
    
    public static String getStatusDesByCode(int statusCode) {
        for (ResponseStatusType status : ResponseStatusType.values()) {
            if (status.getStatusCode() == statusCode) {
                return status.getStatusDes();
            }
        }
        return null;
    }

    public String getStatusDes() {
        return statusDes;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
