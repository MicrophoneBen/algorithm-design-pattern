package com.thread.pool.service;

import com.thread.pool.base.CallableTemplate;

import java.util.HashMap;
import java.util.Map;

/*
 * @desc 这个类继承了上面的CallableTemplate，我们要的返回值是Map，因此泛型类型是Map，
 * 在类中还重写了process方法，在方法中调用发送邮件的业务逻辑接口SendMessageService.sendMessage，
 * 并将返回结果组装成Map返回，这里我就简单处理了，将邮件地址及内容放在Map中直接返回了；
 * 另外还要注意这个类有个有参构造器，通过构建器可以接收需要传递进来的参数
 */

/**
 * @author zhangbingquan
 * @desc 多线程发送邮件处理类
 * @time 2019-09-12 22:39
 */
public class SendMessageHandler extends CallableTemplate<Map<String, String>> {
    private String email;
    private String content;

    public SendMessageHandler(String email, String content) {
        this.email = email;
        this.content = content;
    }


    @Override
    public Map<String, String> process() {
        SendMessageService sendMessageService = new SendMessageService();
        sendMessageService.sendMessage(email, content);
        Map<String, String> map = new HashMap<>();
        map.put(email, content);
        return map;
    }
}
