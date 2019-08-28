package com.design.pattern.listener.handler;

import com.design.pattern.listener.Event;

/**
 * @author zhangbingquan
 * @desc 事件监听器的实现类
 * @time 2019/8/23 0:41
 */
public class MyListener implements EventListener {


    @Override
    public void handlerEvent(Event event) {
        event.callBack();
    }
}
