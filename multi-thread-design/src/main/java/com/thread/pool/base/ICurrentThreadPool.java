package com.thread.pool.base;

import java.util.List;
import java.util.concurrent.ExecutionException;
/*
 *IConcurrentThreadPool是多线程接口类，
 *声名了三个方法，initConcurrentThreadPool:初始化线程池，
 *submit：提交单个任务的线程，并有返回值，
 *invokeAll：提交多个任务的线程，并有返回值
 */


/**
 * @author zhangbingquan
 * @desc 多线程的线程池接口类
 * @time 2019-09-12 22:02
 */
public interface ICurrentThreadPool {
    /**
     * 初始化线程池
     */
    void initConcurrentThreadPool();

    /**
     * 提交单个任务
     *
     * @param task
     * @return
     */
    <V> V submit(CallableTemplate<V> task) throws InterruptedException,
            ExecutionException;

    /**
     * 提交多个任务
     *
     * @param tasks
     * @return
     */
    <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks)
            throws InterruptedException, ExecutionException;

    void closeConcurrentThreadPool();
}
