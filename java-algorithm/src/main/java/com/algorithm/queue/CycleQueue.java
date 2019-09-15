package com.algorithm.queue;

/**
 * @author zhangbingquan
 * @desc 循环队列实现 先进先出，队尾进队头出
 * @time 2019/8/30 1:43
 */
public class CycleQueue extends AbstractQueue implements Queue {

    public CycleQueue() {
        init(defaultSize);
    }

    public CycleQueue(int size) {
        init(size);
    }

    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Object[size];
    }

    @Override
    public boolean append(Object object) throws Exception {
        //入队 操作，首先判满
        if (count > 0 && rear == front) {
            throw new Exception("队列已满");
        }
        //否则开始入队
        queue[rear] = object;
        //循环队列的移位指针公式
        rear = (rear + 1) % maxSize;
        count++;
        return true;
    }

    @Override
    public Object delete() throws Exception {
        //出队，队列判空先
        if(count == 0 && rear == front){
            throw new Exception("队列为空，无法出队");
        }
        Object obj =  queue[front];
        front = (front + 1) % maxSize;
        count--;
        return obj;
    }

    @Override
    public Object getFront() throws Exception {
        //取队头元素，队列首先判空
        if(count == 0 && front == rear){
            throw new Exception("队列为空");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
