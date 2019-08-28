package com.design.pattern.singleton;

/**
 * @author zhangbingquan
 * @desc 单例设计模式，一个静态私有成员变量，一个私有构造方法，一个静态公有的工厂方法
 * @time 2019/7/30 22:38
 */
public class SingletonPattern {
    //静态的私有成员变量
    private static SingletonPattern instance;
    //私有的构造方法，保证类不能被外部实例化
    private SingletonPattern(){}

    //静态公有的工厂方法，返回全局的唯一实例
    public static SingletonPattern getInstance(){
        if(instance == null){
            instance = new SingletonPattern();
            return instance;
        }else {
            return instance;
        }
    }


}
