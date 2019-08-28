package com.design.pattern.adapter.adaptee;

/**
 * @author zhangbingquan
 * @desc 原来的类，需要适配的类
 * @time 2019/8/18 22:07
 */
public class Bird {
    public void cry(){
        System.out.println("我是鸟儿，鸟儿唧唧叫");
    }

    public void move(){
        System.out.println("我是鸟儿，鸟儿飞飞");
    }
}
