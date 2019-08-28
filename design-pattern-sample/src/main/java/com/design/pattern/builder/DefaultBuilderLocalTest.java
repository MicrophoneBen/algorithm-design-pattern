package com.design.pattern.builder;

import com.design.pattern.builder.product.AbstractPastryBuilder;
import com.design.pattern.builder.product.BreadBuilder;
import com.design.pattern.builder.product.CakeBuilder;
import com.design.pattern.builder.product.Pastry;

/**
 * @author zhangbingquan
 * @desc 建造者模式的本地测试类
 * @time 2019/7/28 23:09
 */
public class DefaultBuilderLocalTest {
    public static void main(String[] args) {
        //外界动态指定生产哪一种糕点
//        AbstractPastryBuilder builder = new BreadBuilder();
        AbstractPastryBuilder builder = new CakeBuilder();

        //厨师是指挥者
        PastryChief chief = new PastryChief();

        //厨师制作糕点
        chief.setPastryBuilder(builder);

        //产出糕点交给客户
        Pastry bread = chief.constructProduct();

        //糕点名字
        System.out.println("糕点的名字:  ============>>>>>>" + bread.getPastryName());
        System.out.println("糕点的详细信息" + bread.toString());
    }
}
