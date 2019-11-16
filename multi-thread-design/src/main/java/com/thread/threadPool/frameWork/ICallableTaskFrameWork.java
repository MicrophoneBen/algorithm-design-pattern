package com.thread.threadPool.frameWork;

import com.thread.threadPool.CallableTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangbingquan
 * @version 2019年09月12日
 * @since 2019年09月12日
 **/
public interface ICallableTaskFrameWork {
    <V> List<V> submitsAll(List<? extends CallableTemplate<V>> tasks)
            throws InterruptedException, ExecutionException;
}
