package com.design.pattern.observer.objectObserver;

import com.design.pattern.observer.AbstractObserveSubject;
import com.design.pattern.observer.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangbingquan
 * @desc 小猫猫观察者目标
 * @time 2019-09-14 21:04
 */
@Slf4j
public class CatObserveSubject extends AbstractObserveSubject {
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void ObseverNotify() {
        log.info("我是一只小猫咪，喵喵喵！！！");
        for(Observer observer : observers){
            observer.update();
        }
    }
}
