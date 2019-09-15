package com.thread.pool.frameWork;

import com.thread.pool.base.CallableTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangbingquan
 * @desc 线程任务框架接口，所有的多线程调用都通过这个接口来实现
 * @time 2019-09-12 22:16
 */
public interface ICallableFrameWork {
    <V>List<V> submitAll(List<? extends CallableTemplate<V>> tasks)
            throws InterruptedException, ExecutionException;
}
