package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 海康威视电视机实体类
 * @time 2019/7/27 23:03
 */
public class HikTv implements Tv {
    @Override
    public void play() {
        System.out.println("海康威视电视机正在播放");
    }
}
