package com.thread.extendThread;

/**
 * @author zhangbingquan
 * @version 2019年09月10日
 * @since 2019年09月10日}
 **/
public class DefaultMain {
    public static void main(String[] args) {
        ExtendThread extendThread = new ExtendThread("递归求和数组1", 1);
        extendThread.start();


        extendThread = new ExtendThread("递归求和数组2", 20);
        extendThread.start();

    }
}
