package com.design.pattern.observer;

import com.design.pattern.observer.AbstractObserveSubject;
import com.design.pattern.observer.Observer;
import com.design.pattern.observer.concreteObserver.DogObserver;
import com.design.pattern.observer.concreteObserver.HosterObserver;
import com.design.pattern.observer.concreteObserver.MouseObserver;
import com.design.pattern.observer.objectObserver.CatObserveSubject;

/**
 * @author zhangbingquan
 * @desc 观察者模式的默认测试方法
 * @time 2019-09-14 21:30
 */
public class DefaultObserverTest {
    public static void main(String[] args) {
        //首先有一个观察目标
        AbstractObserveSubject observeSubject = new CatObserveSubject();

        //有两个观察者
        Observer mouseObserver, dogObserver;
        mouseObserver = new MouseObserver();
        dogObserver = new DogObserver();

        observeSubject.attach(mouseObserver);
        observeSubject.attach(dogObserver);

        Observer hostObserver = new HosterObserver();
        observeSubject.attach(hostObserver);

        observeSubject.ObseverNotify();
    }
}
