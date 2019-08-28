package com.design.pattern.abstractFactory.btn;

/**
 * @author zhangbingquan
 * @desc Linux系统下的按钮实现类，提供点击操作
 * @time 2019/7/28 18:34
 */
public class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("一个Linux系统下的按钮，提供点击操作");
    }
}
