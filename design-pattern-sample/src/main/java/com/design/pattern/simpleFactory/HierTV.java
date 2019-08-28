package com.design.pattern.simpleFactory;

/**
 * @author zhangbingquan
 * @desc 海尔电视实现类
 * @time 2019/7/26 21:37
 */
public class HierTV implements Television {

    @Override
    public String play() {
        return "海尔电视正在播放";
    }
}
