package com.design.pattern.adapter.adaptee;

import com.design.pattern.adapter.Robot;

/**
 * @author zhangbingquan
 * @desc 对象适配器
 * @time 2019/8/18 23:13
 */
public class ObjectBirdAdapter implements Robot {
    private Bird birdAdapter = new Bird();
    @Override
    public void move() {
        System.out.println("机器人适配类，适配鸟儿的移动，其实就是飞翔》》》》》》》》》》》》》");
        birdAdapter.move();
    }

    @Override
    public void cry() {
        System.out.println("机器人适配类，适配鸟儿的鸟叫，其实就是唧唧叫》》》》》》》》》》》》》");
        birdAdapter.cry();
    }
}
