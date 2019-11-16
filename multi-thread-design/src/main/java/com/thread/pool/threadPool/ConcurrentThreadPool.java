package com.thread.pool.threadPool;

import com.thread.pool.base.CallableTemplate;
import com.thread.pool.base.ICurrentThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
 * @desc ConcurrentThreadPool是创建线程池的实现类，
 * 用到了ThreadPoolExecutor线程池类及这个类的invokeAll方法和submit方法，
 * 这两个方法的返回值，都可以通过Future类的get方法获得
 */

/**
 * @author zhangbingquan
 * @desc 继承实现ICurrentThreadPool接口，做一个线程池
 * @time 2019-09-12 22:07
 */
public class ConcurrentThreadPool implements ICurrentThreadPool {
    private ThreadPoolExecutor threadPoolExecutor;
    // 核心线程数
    private int corePoolSize = 30;
    // 最大线程数
    private int maximumPoolSize = 50;
    // 超时时间30秒
    private long keepAliveTime = 300;

    //初始化线程池
    @Override
    public void initConcurrentThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    //关闭线程池
    public void closeConcurrentThreadPool() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    @Override
    public <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException {
        Future<V> result = threadPoolExecutor.submit(task);
        return result.get();
    }

    @Override
    public <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        List<Future<V>> taskResult = threadPoolExecutor.invokeAll(tasks);
        List<V> resultList = new ArrayList<>();
        for (Future<V> task : taskResult) {
            resultList.add(task.get());
        }
        return resultList;
    }
}
