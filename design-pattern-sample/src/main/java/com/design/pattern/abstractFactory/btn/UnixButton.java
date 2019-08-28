package com.design.pattern.abstractFactory.btn;

/**
 * @author zhangbingquan
 * @desc 一个Unix系统下的实现类，提供点击操作
 * @time 2019/7/28 18:35
 */
public class UnixButton implements Button {
    @Override
    public void click() {
        System.out.println("一个Unix系统下的按钮，提供点击操作");
    }
}
