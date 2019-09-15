package com.thread.pool.base;

import java.util.concurrent.Callable;
/*
*CallableTemplate类实现了Callable接口，并实现了process方法，该类是一个抽象类，
* 接收任意返回值的类型，
* beforeProcess方法为前置处理，
* afterProcess的后置处理，
* process为具体的业务逻辑抽象方法，
* 该方法在子类中实现
*/

/**
 * @author zhangbingquan
 * @desc 实现Callable接口，实现自己定义的线程执行函数
 * @time 2019-09-12 21:56
 * 多线程模板类
 */
public abstract class CallableTemplate<V> implements Callable<V> {
    /**
     * 前置处理，子类可以Override该方法
     */
    public void beforeProcess() {
        System.out.println("before process....");
    }

    /**
     * 处理业务逻辑的方法,需要子类去Override
     *
     * @return
     */
    public abstract V process();

    /**
     * 后置处理，子类可以Override该方法
     */
    public void afterProcess() {
        System.out.println("after process....");
    }

    @Override
    public V call() throws Exception {
        beforeProcess();
        V result = process();
        afterProcess();
        return result;
    }
}
