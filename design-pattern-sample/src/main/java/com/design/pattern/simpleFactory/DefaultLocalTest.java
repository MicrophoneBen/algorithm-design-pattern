package com.design.pattern.simpleFactory;

import com.design.pattern.factoryMethed.HaierTvFactory;
import com.design.pattern.factoryMethed.Tv;
import com.design.pattern.simpleFactory.Television;
import com.design.pattern.simpleFactory.TvFactory;

/**
 * @author zhangbingquan
 * @desc 本地测试的默认分支
 * @time 2019/7/26 22:02
 */
public class DefaultLocalTest {
    public static void main(String[] args) {

        // 简单工厂类测试
        Television television;

        television = TvFactory.createTv("海尔");
        System.out.println(television.play());


        television = TvFactory.createTv("海神");
        System.out.println(television.play());


        television = TvFactory.createTv("海康威视");
        System.out.println(television.play());



        //工厂方法类测试
        System.out.println("工厂方法类测试开始");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>=================================>>>>>>>>>>>>>>>>");
        Tv tv;
        com.design.pattern.factoryMethed.TvFactory tvFactory;

        //这里需要制定使用哪一个工厂类来生产电视机，通常这里通过JNDI来使用外部配置文件制定创建哪一个工厂对象。
        Class<?> clazz = com.design.pattern.factoryMethed.TvFactory.class;
        //生产海尔电视机
                 clazz = HaierTvFactory.class;
        try {
            HaierTvFactory instance = (HaierTvFactory)clazz.newInstance();
            tv = instance.produceTv();
            tv.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
