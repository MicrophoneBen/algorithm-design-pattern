package com.design.pattern.listener.source;

import com.design.pattern.listener.handler.EventListener;

/**
 * @author zhangbingquan
 * @desc 事件源接口
 * @time 2019/8/23 0:43
 */
public interface EventSource {
    /**
     * @author zhangbingquan
     * @desc 增加监听器
     * @time 2019/8/23 0:43
     */
    void addListener(EventListener listener);


    /**
     * @author zhangbingquan
     * @desc 通知监听器
     * @time 2019/8/23 0:44
     */
    void notifyListener();
}
