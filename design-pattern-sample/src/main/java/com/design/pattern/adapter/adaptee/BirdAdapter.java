package com.design.pattern.adapter.adaptee;

import com.design.pattern.adapter.Robot;

/**
 * @author zhangbingquan
 * @desc 鸟儿适配器，这里是类适配器
 *
 * 类适配器的实现是，适配器实现适配者的子类，然后实现待适配的接口
 * @time 2019/8/18 22:09
 */
public class BirdAdapter extends Bird implements Robot {

    @Override
    public void move() {
        System.out.println("机器人类适配者，通过机器人适配>>>>>>>>>>>>>>>>");
        super.move();
    }

    @Override
    public void cry() {
        System.out.println("机器人类适配者，通过机器人适配>>>>>>>>>>>>>>>>");
        super.cry();
    }
}
