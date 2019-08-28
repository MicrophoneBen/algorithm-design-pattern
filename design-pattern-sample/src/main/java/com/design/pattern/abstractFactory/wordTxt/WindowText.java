package com.design.pattern.abstractFactory.wordTxt;

/**
 * @author zhangbingquan
 * @desc 一个window系统下的文本展示框实现类，展示一段文字内容
 * @time 2019/7/28 18:37
 */
public class WindowText implements Text {
    @Override
    public void display() {
        System.out.println("一个Window系统下的文本框实现类，用来展示一段文字的文本框");
    }
}
