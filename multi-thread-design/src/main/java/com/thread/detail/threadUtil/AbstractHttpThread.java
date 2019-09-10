package com.thread.detail.threadUtil;

import java.util.concurrent.Callable;

/**
 * @author zhangbingquan
 * @version 2019年09月07日
 * @since 2019年09月07日}
 **/
public abstract class AbstractHttpThread<V> implements Callable<V> {
    /**
     * @return    void
     * @desc      线程前置处理方法，线程开始执行先调用该方法，子类可以重写
     **/
    public void beforeProcess(){
        System.out.println("Http线程开始执行===================>>>>>>>>>>>>>>>>>>");
    }

    /**
     * @return    V
     * @desc      业务逻辑处理方法，处理业务逻辑，需要子类重写实现
     **/
    public abstract V process();

    /**
     * @return    void
     * @desc      线程后置处理方法，线程处理完毕后调用该方法，子类可以重写
     **/
    public void afterProcess(){
        System.out.println("Http线程执行完毕=================>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public V call() throws Exception {
       beforeProcess();
       V result = process();
       afterProcess();
       return result;
    }
}
