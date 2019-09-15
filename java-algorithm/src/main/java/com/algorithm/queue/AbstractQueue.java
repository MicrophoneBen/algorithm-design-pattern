package com.algorithm.queue;

/**
 * @author zhangbingquan
 * @desc 抽象队列类
 * @time 2019/8/30 1:48
 */
public class AbstractQueue implements Queue {
    /*
     * @author zhangbingquan
     * @desc 默认队列的长度
     * @time 2019/8/30 1:59
     */
    static final int defaultSize = 10;
    /**
     * @author zhangbingquan
     * @desc 队尾
     */
    int rear;
    /**
     * @author zhangbingquan
     * @desc 队头
     */
    int front;
    /**
     * @author zhangbingquan
     * @desc 统计队列元素的计数器
     */
    int count;

    /**
     * @author zhangbingquan
     * @desc 队列的最大长度
     */
    int maxSize;
    /**
     * @author zhangbingquan
     * @desc 队列元素
     */
    Object[] queue;


    @Override
    public boolean append(Object object) throws Exception {
        return false;
    }

    @Override
    public Object delete() throws Exception {
        return null;
    }

    @Override
    public Object getFront() throws Exception {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
