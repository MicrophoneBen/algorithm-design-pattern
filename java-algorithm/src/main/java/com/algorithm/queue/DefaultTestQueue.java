package com.algorithm.queue;

/**
 * @author zhangbingquan
 * @desc 循环队列的测试类
 * @time 2019/8/30 2:41
 */
public class DefaultTestQueue {
    public static void main(String[] args) throws Exception {
       String str  = "HelloChina";
       char[] chars = str.toCharArray();

       CycleQueue cycleQueue = new CycleQueue(chars.length);
       for(char ch : chars){
           cycleQueue.append(ch);
       }
        System.out.println(cycleQueue.count);
        System.out.println(cycleQueue.toString());
        cycleQueue.delete();
        cycleQueue.delete();
        System.out.println(cycleQueue.toString());

    }
}
