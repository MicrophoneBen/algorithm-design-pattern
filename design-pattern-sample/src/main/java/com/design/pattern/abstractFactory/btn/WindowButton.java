package com.design.pattern.abstractFactory.btn;

/**
 * @author zhangbingquan
 * @desc 具体的widow系统，按钮实现类
 * @time 2019/7/28 18:33
 */
public class WindowButton implements Button {
    @Override
    public void click() {
        System.out.println("一个widow系统下的桌面按钮，提供点击操作");
    }
}
