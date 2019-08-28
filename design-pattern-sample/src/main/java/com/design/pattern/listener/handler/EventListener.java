package com.design.pattern.listener.handler;

import com.design.pattern.listener.Event;

/**
 * @author zhangbingquan
 * @desc 事件的监听器接口
 * @time 2019/8/23 0:40
 */
public interface EventListener {
    /**
     * @author zhangbingquan
     * @desc 事件触发方法
     * @time 2019/8/23 0:40
     */
    void handlerEvent(Event event);
}
