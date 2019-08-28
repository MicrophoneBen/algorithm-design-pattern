package com.design.pattern.abstractFactory.wordTxt;

/**
 * @author zhangbingquan
 * @desc 一个Linux系统下的文本框实现类，用来展示一段文字的文本框
 * @time 2019/7/28 18:39
 */
public class LinuxText implements Text {
    @Override
    public void display() {
        System.out.println("Linux系统下的文本框实现类，用来展示一段文字");
    }
}
