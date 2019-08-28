package com.design.pattern.simpleFactory;

/**
 * @author zhangbingquan
 * @desc 海康威视电视机接口实现类
 * @time 2019/7/26 21:46
 */
public class HaikungTv implements Television {
    @Override
    public String play() {
        return "海康威视电视机正在播放";
    }
}
