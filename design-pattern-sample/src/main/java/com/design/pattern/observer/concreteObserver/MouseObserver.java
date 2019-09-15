package com.design.pattern.observer.concreteObserver;

import com.design.pattern.observer.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangbingquan
 * @desc 老鼠观察者
 * @time 2019-09-14 19:34
 */
@Slf4j
public class MouseObserver implements Observer {
    @Override
    public void update() {
        log.info("猫叫唤了，猫在旁边，老鼠赶紧躲好#########");
    }


}
