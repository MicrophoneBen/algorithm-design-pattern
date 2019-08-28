package com.design.pattern.listener;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangbingquan
 * @desc 事件三要素，事件源，事件时间，事件主题消息，通过事件传递的消息
 * @time 2019/8/20 1:23
 */
public interface Event extends Serializable {
    /**
     * @author zhangbingquan
     * @desc 事件源
     * @time 2019/8/20 1:25
     */
    Object getSource();

    /**
     * @author zhangbingquan
     * @desc 事件时间
     * @time 2019/8/20 1:26
     */
    Date getWhen();

    /**
     * @author zhangbingquan
     * @desc 获取事件详情
     * @time 2019/8/20 1:26
     */
    String getMessage();

    /**
     * @author zhangbingquan
     * @desc 事件；回调方法
     * @time 2019/8/20 1:27
     */
    void callBack();
}
