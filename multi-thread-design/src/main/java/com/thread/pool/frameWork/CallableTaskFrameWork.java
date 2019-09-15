package com.thread.pool.frameWork;

import com.thread.pool.base.CallableTemplate;
import com.thread.pool.base.ICurrentThreadPool;
import com.thread.pool.threadPool.ConcurrentThreadPool;

import java.util.List;
import java.util.concurrent.ExecutionException;
/**
 * @desc CallableTaskFrameWork是ICallableTaskFrameWork 的实现类，
 * 在submitsAll实现方法中，通过调用线程池对象IConcurrentThreadPool接口的invokeAll方法来发起多线程的调用，
 * 这里注意一个，在submitAll实现方法中，
 * 我手动的调用了初始化线程池的方法concurrentThreadPool.initConcurrentThreadPool()，
 * 在真实的项目上，应该在应用启动的时候就调用该方法来初始化线程池
 */


/**
 * @author zhangbingquan
 * @desc CallableTaskFrameWork是ICallableTaskFrameWork 的实现类
 * @time 2019-09-12 22:19
 */
public class CallableTaskFrameWork implements ICallableFrameWork {
    private ICurrentThreadPool currentThreadPool = new ConcurrentThreadPool();

    @Override
    public <V> List<V> submitAll(List<? extends CallableTemplate<V>> tasks) throws InterruptedException, ExecutionException {
        currentThreadPool.initConcurrentThreadPool();
        return currentThreadPool.invokeAll(tasks);
    }

    public void closeAll(){
        currentThreadPool.closeConcurrentThreadPool();
    }
}
