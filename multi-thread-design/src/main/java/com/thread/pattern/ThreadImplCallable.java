package com.thread.pattern;

import java.util.concurrent.Callable;

/**
 * @author zhangbingquan
 * @version 2019年09月10日
 * @since 2019年09月10日
 * 实现Callable接口来实现多线程，主要是可以获取到线程的返回值，通过featureTask.get()获取
 **/
public class ThreadImplCallable<V> implements Callable<V> {
    /**
     * @desc 线程名称
     **/
    private String threadName;
    /**
     * @desc 线程携带的参数
     **/
    private Integer threadVal;

    public ThreadImplCallable(String threadName, Integer threadVal) {
        this.threadName = threadName;
        this.threadVal = threadVal;
    }


    /**
     * @return V
     * @desc 重写接口Callable, 代表这个一个可以被调用的线程
     **/
    @Override
    public V call() throws Exception {
        System.out.println(threadName);
        int sum = 0;
        if (threadVal < 100) {
            for (int i = threadVal; i <= 100; i++) {
                sum += i;
            }
            return (V) String.valueOf(sum);
        } else {
            throw new Exception("线程参数有误");
        }
    }
}
