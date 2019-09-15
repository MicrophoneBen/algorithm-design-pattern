package com.thread.pool.service;

/**
 * @author zhangbingquan
 * @desc 发送消息的服务类
 * @time 2019-09-12 22:23
 */
public class SendMessageService {
    public void sendMessage(String email, String content){
        System.out.println("发送邮件信息==========>>>>>>>>");
        System.out.println(email + content);
        System.out.println();
    }
}
