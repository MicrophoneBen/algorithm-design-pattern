package com.design.pattern.listener.source;

import com.design.pattern.listener.MyEvent;
import com.design.pattern.listener.handler.EventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangbingquan
 * @desc 事件源实现类
 * @time 2019/8/23 0:45
 */
public class MySource implements EventSource {
    private List<EventListener> listeners = new ArrayList<>();
    private int value;


    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyListener() {
        for (EventListener listener : listeners) {
            MyEvent event = new MyEvent();
            event.setSource(this);
            event.setWhen(new Date());
            event.setMessage("setValue " + value);
            listener.handlerEvent(event);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyListener();
    }
}
