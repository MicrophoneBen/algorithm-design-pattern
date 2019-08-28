package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 海康威视电视机工厂类
 * @time 2019/7/27 23:06
 */
public class HiKTVFactory implements TvFactory {
    @Override
    public Tv produceTv() {
        System.out.println("海康威视电视机工厂类生产电视机");

        return new HikTv();
    }
}
