package com.design.pattern.abstractFactory.wordTxt;

/**
 * @author zhangbingquan
 * @desc Unix系统下的文本框 实现类，用来展示一段文字的文本框。Unix系统中使用
 * @time 2019/7/28 18:40
 */
public class UnixText implements Text {
    @Override
    public void display() {
        System.out.println("Unix系统下的文本框实现类，用来展示一段在Unix系统下的文字");
    }
}
