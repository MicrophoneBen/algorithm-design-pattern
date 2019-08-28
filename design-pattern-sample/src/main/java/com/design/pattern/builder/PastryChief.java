package com.design.pattern.builder;

import com.design.pattern.builder.product.AbstractPastryBuilder;
import com.design.pattern.builder.product.Pastry;

/**
 * @author zhangbingquan
 * @desc 建造者设计模式中的指挥者，这里是糕点师傅，即厨师
 * @time 2019/7/28 23:11
 */
public class PastryChief {

    private AbstractPastryBuilder pastryBuilder;

    public void setPastryBuilder(AbstractPastryBuilder pastryBuilder){
        this.pastryBuilder = pastryBuilder;
    }

    public Pastry constructProduct(){
        pastryBuilder.buyEgg();
        pastryBuilder.buyWater();
        pastryBuilder.createPastryCream();
        pastryBuilder.produceTimeTag();
        pastryBuilder.setPastryName();
        return pastryBuilder.getPastry();
    }
}
