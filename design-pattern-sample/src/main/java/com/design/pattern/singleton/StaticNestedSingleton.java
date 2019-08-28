package com.design.pattern.singleton;

/**
 * @author zhangbingquan
 * @desc 静态内部类实现懒汉式单例
 * @time 2019/7/30 23:21
 */
public class StaticNestedSingleton {

    private static class SingletonHolder {
        private static final StaticNestedSingleton INSTANCE = new StaticNestedSingleton();
    }
    /*
     * @author zhangbingquan
     * @desc 这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder是私有的，
     *       除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，
     *       没有性能缺陷；也不依赖 JDK 版本。
     * @time 2019/7/30 23:23
     */

    private StaticNestedSingleton (){}


    public static final StaticNestedSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
