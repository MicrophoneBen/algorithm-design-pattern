package com.thread.extendThread;

/**
 * @author zhangbingquan
 * @version 2019年09月10日
 * @since 2019年09月10日
 **/
public class ExtendThread extends Thread {
    /**
     * @desc 线程名字
     **/
    private String threadName;
    /**
     * @desc 线程计算初始化值
     **/
    private Integer threadVal;

    public ExtendThread(String threadName, Integer threadVal) {
        this.threadName = threadName;
        this.threadVal = threadVal;
    }

    @Override
    public void run() {
        System.out.println("当前线程的名称=========>>>>>" + this.threadName);
        int sum = 0;
        for (int i = threadVal; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    //一个递归求和的方法
    private Integer getRecursiveSum(Integer threadVal) {
        Integer sum = 0;
        if (threadVal <= 100) {
            return sum + getRecursiveSum(threadVal + 1);
        }
        return sum;
    }
}
