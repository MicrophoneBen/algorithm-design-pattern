package com.design.pattern.builder.product;

import com.design.pattern.builder.middleProduct.PastryCream;

import java.time.LocalDateTime;

/**
 * @author zhangbingquan
 * @desc 面包糕点建造者实现类，生产面包糕点
 * @time 2019/7/28 22:22
 */
public class BreadBuilder extends AbstractPastryBuilder {
    @Override
    public boolean createPastryCream() {
        //这里可以使用简单工厂、工厂方法、抽象工厂来生产奶油
        System.out.println("生产制作面包使用的奶油");
        PastryCream pastryCream = new PastryCream("羊奶", "白砂糖", "自来水");
        pastry.setPastryCream(pastryCream);
        System.out.println("奶油的详细信息=============>>>>>>>>>>" + pastryCream.toString());
        return true;
    }

    @Override
    public void produceTimeTag() {
        pastry.setProductinTime(LocalDateTime.now());
    }

    @Override
    public void buyEgg() {
        pastry.setEgg("鸡蛋");
    }

    @Override
    public void buyWater() {
        pastry.setWater("矿泉水");
    }

    @Override
    public void setPastryName() {
        pastry.setPastryName("鸡蛋奶油面包");
    }
}
