package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 小米电视机实现类
 * @time 2019/7/27 23:33
 */
public class XiaomiTv implements Tv {
    @Override
    public void play() {
        System.out.println("小米电视机正在播放");
    }
}
