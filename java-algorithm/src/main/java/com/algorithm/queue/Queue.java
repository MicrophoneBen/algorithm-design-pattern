package com.algorithm.queue;

/**
 * @author zhangbingquan
 * @desc 队列的抽象接口
 * @time 2019/8/30 1:46
 */
public interface Queue {
    /*
     * @desc 入队
     * @return boolean
     */
    public boolean append(Object object)throws Exception;
    /*
     * @desc 删除元素
     * @return java.lang.Object
     */
    public Object delete() throws Exception;
    /*
     * @desc 获取队头元素
     * @return java.lang.Object
     */
    public Object getFront() throws Exception;
    /*
     * @desc 队列判空，队列为空返回true
     * @return boolean
     */
    public boolean isEmpty();
}
