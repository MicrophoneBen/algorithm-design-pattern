package com.design.pattern.singleton;

/**
 * @author zhangbingquan
 * @desc 改进的懒汉式单例, 这个模式综合运用了java的类级内部类和多线程缺省同步锁的知识
 * @time 2019/7/30 23:10
 */
public class SuperLazySingleton {
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定的关系，而且只有被调用到才会装载，从而实现了延迟加载
     * @author qian.xu
     *
     */
    private static class Singleton{
        /**
         * 静态初始化器，用JVM来保证线程安全
         */
        private static SuperLazySingleton singleton = new SuperLazySingleton();

        static {
            System.out.println("---->类级的内部类被加载");
        }
        private Singleton(){
            System.out.println("---->类级的内部类构造函数被调用");
        }
    }
    //私有化构造函数
    private SuperLazySingleton(){
        System.out.println("-->开始调用构造函数");
    }
    //开放一个公有方法，判断是否已经存在实例，有返回，没有新建一个在返回
    public static SuperLazySingleton getInstance(){
        System.out.println("-->开始调用公有方法返回实例");
        SuperLazySingleton s1 = null;
        s1 = Singleton.singleton;
        System.out.println("-->返回单例");
        return s1;
    }
}
