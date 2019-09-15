package com.design.pattern.observer.concreteObserver;

import com.design.pattern.observer.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangbingquan
 * @desc 狗狗观察者
 * @time 2019-09-14 19:40
 */
@Slf4j
public class DogObserver implements Observer {
    @Override
    public void update() {
        log.info("猫叫了，狗也开始叫唤~~~~~");
    }

}
