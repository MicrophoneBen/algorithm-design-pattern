package com.thread.runnable;

import java.util.Map;

/**
 * @author zhangbingquan
 * @version 2019年09月10日
 * @since 2019年09月10日}
 **/
public class ThreadImplRunnable implements Runnable {
    /**
     * 线程名称
     */
    private String threadName;

    /**
     * @desc 传递给线程的参数
     **/
    private Map<String, Object> threadMap;

    /**
     * 构造函数
     *
     * @param threadName 线程名称
     */
    public ThreadImplRunnable(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        System.out.println(threadName);
    }
}
