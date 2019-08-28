package com.design.pattern.adapter;

/**
 * @author zhangbingquan
 * @desc 待适配的适配接口
 * @time 2019/8/18 22:05
 */
public interface Robot {
    /**
     * @author zhangbingquan
     * @desc 需要被适配的适配者接口
     * @time 2019/8/18 22:06
     */
    public void move();

    /**
     * @author zhangbingquan
     * @desc 需要适配的叫声接口
     * @time 2019/8/18 22:07
     */
    public void cry();
}
