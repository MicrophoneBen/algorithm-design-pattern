package com.design.pattern.singleton;

/**
 * @author zhangbingquan
 * @desc 懒汉式单例
 * @time 2019/7/30 22:52
 */
public class LazySingleton {
    //声明成 volatile
    private volatile static LazySingleton instance;

    private LazySingleton(){}

    /**
     * 这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
     *      给 instance 分配内存
     *      调用 Singleton 的构造函数来初始化成员变量
     *      将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
     * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，
     * 则在 3 执行完毕、2 未执行之前，被线程二抢占了，
     * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，
     * 然后使用，然后顺理成章地报错。
     *
     * 我们只需要将 instance 变量声明成 volatile 就可以了。
     */

    public static LazySingleton getInstance(){
            //加多一层判断空的，使对象在不空的时候直接返回，不用进入加锁，降低系统性能
        if(null == instance){
            //如果getInstance()方法未被同步，并且线程A和线程B同时调用了这个方法，
            // 就会出现if(instance == null)的返回值都是true，然后就会在内存中同时创建两个对象
            synchronized (LazySingleton.class){
                //加这一层判断空，是因为在大请求时候，防止在加锁的时候，有其他请求过来导致实例被创建了多个
                if (null == instance){
                    return new LazySingleton();
                }
            }
        }
        return instance;
    }
}
