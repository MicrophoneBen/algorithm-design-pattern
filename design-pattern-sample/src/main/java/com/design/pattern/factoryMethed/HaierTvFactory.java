package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 海尔电视机工厂类
 * @time 2019/7/27 22:58
 */
public class HaierTvFactory implements TvFactory {

    @Override
    public Tv produceTv() {

        System.out.println("海尔电视机工厂生产电视机");

        return new HaierTv();
    }
}
