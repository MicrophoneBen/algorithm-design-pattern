package com.design.pattern.observer.concreteObserver;

import com.design.pattern.observer.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangbingquan
 * @desc 家庭主人观察者
 * @time 2019-09-14 21:40
 */
@Slf4j
public class HosterObserver implements Observer {
    @Override
    public void update() {
      log.info("猫开始叫唤了，小猫猫饿了==========》》》》》  喂猫");

      log.info("狗开始叫唤了，小狗饿了============》》》》》  喂狗");

      log.info("老鼠一定是躲到老鼠洞里了，拿东西堵到老鼠洞口=====》》》》》   堵老鼠");
    }
}
