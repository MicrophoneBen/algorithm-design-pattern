package com.thread.runnable;

/**
 * @author zhangbingquan
 * @version 2019年09月11日
 * @since 2019年09月11日}
 **/
public class DefaultRunnableTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadImplRunnable threadImplRunnable = new ThreadImplRunnable("Thread1");
        new Thread(threadImplRunnable).start();


        threadImplRunnable = new ThreadImplRunnable("Thread2");
        new Thread(threadImplRunnable).start();
        Thread.sleep(100);
        System.out.println("end");
    }
}
