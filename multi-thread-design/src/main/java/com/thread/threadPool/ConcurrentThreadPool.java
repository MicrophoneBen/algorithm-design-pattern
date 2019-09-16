package com.thread.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhangbingquan
 * @version 2019年09月12日
 * @since 2019年09月12日
 **/
public class ConcurrentThreadPool implements IConcurrentThreadPool {
    private ThreadPoolExecutor threadPoolExecutor;
    /**核心线程数*/
    private int corePoolSize = 10;
    /**最大线程数*/
    private int maxMumPoolSize = 50;
    /**超时300毫秒*/
    private long keepAliveTime = 300;

    @Override
    public void initConcurrentThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maxMumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
    }

    @Override
    public <V> V submit(CallableTemplate<V> task) throws InterruptedException, ExecutionException {
        Future<V> result = threadPoolExecutor.submit(task);
        return result.get();
    }

    @Override
    public <V> List<V> invokeAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        List<Future<V>> tasksResult = threadPoolExecutor.invokeAll(tasks);
        List<V> resultList = new ArrayList<>();
        for (Future<V> future : tasksResult){
            resultList.add(future.get());
        }
        return resultList;
    }
}
