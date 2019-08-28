package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 海尔电视机实现类
 * @time 2019/7/27 22:56
 */
public class HaierTv implements Tv {
    @Override
    public void play() {
        System.out.println("海尔电视机正在播放");
    }
}
