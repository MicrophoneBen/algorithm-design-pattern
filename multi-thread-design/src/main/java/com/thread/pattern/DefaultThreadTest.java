package com.thread.pattern;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangbingquan
 * @version 2019年09月10日
 * @since 2019年09月10日}
 **/
public class DefaultThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //执行线程
        Callable<String> threadCallable = new ThreadImplCallable<>("Calculate-thread", 20);
        FutureTask<String> futureTask = new FutureTask<>(threadCallable);
        Thread thread = new Thread(futureTask);
        thread.start();

        String threadReturn = futureTask.get();
        System.out.println("线程的返回结果是====>>>>" + threadReturn);


        //再次启动一个线程
        threadCallable = new ThreadImplCallable<>("Calculate-Thread", 1);
        futureTask = new FutureTask<>(threadCallable);
        thread = new Thread(futureTask);
        thread.start();

        threadReturn = futureTask.get();
        System.out.println("计算线程2的返回结果是=========>>>>>" + threadReturn);
        System.out.println("两个计算线程执行完毕");
    }
}
