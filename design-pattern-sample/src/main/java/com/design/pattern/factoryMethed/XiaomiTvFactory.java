package com.design.pattern.factoryMethed;

/**
 * @author zhangbingquan
 * @desc 小米电视机工厂类
 * @time 2019/7/27 23:35
 */
public class XiaomiTvFactory implements TvFactory{
    @Override
    public Tv produceTv() {
        System.out.println("小米电视机工厂类生产电视机");
        return new XiaomiTv();
    }
}
