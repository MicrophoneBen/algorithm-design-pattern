package com.design.pattern.builder.product;

import com.design.pattern.builder.middleProduct.PastryCream;

import java.time.LocalDateTime;

/**
 * @author zhangbingquan
 * @desc 蛋糕糕点建造者实现类，生产蛋糕
 * @time 2019/7/28 23:00
 */
public class CakeBuilder extends AbstractPastryBuilder {
    @Override
    public boolean createPastryCream() {
        PastryCream pastryCream = new PastryCream("牛奶", "蔗糖", "景田山泉水");
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
        pastry.setEgg("鸡蛋清");
    }

    @Override
    public void buyWater() {
        pastry.setWater("山泉水");
    }

    @Override
    public void setPastryName() {
        pastry.setPastryName("山泉水奶油蛋糕");
    }
}
