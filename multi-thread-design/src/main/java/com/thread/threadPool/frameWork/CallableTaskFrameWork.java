package com.thread.threadPool.frameWork;

import com.thread.threadPool.CallableTemplate;
import com.thread.threadPool.ConcurrentThreadPool;
import com.thread.threadPool.IConcurrentThreadPool;

import java.util.List;
import java.util.concurrent.ExecutionException;
/*
 * CallableTaskFrameWork是ICallableTaskFrameWork 的实现类，在submitsAll实现方法中，
 * 通过调用线程池对象IConcurrentThreadPool接口的invokeAll方法来发起多线程的调用，
 * 这里注意一个，在submitAll实现方法中，我手动的调用了初始化线程池的方法concurrentThreadPool.initConcurrentThreadPool()，
 * 在真实的项目上，应该在应用启动的时候就调用该方法来初始化线程池
 */

/**
 * @author zhangbingquan
 * @version 2019年09月12日
 * @since 2019年09月12日
 **/
public class CallableTaskFrameWork implements ICallableTaskFrameWork {
    private IConcurrentThreadPool concurrentThreadPool = new ConcurrentThreadPool();

    @Override
    public <V> List<V> submitsAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        concurrentThreadPool.initConcurrentThreadPool();
        return concurrentThreadPool.invokeAll(tasks);
    }
}
