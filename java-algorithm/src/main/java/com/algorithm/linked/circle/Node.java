package com.algorithm.linked.circle;

import lombok.Data;

/**
 * @author zhangbingquan
 * @desc 单链表的节点类
 * @time 2019-09-10 1:24
 */
@Data
public class Node {
    /**
     * @return 链表节点数据元素
     */
    Object element;

    /**
     * @desc 引用，指向下一个节点
     */
    Node pNext;


    //头结点的构造方法
    public Node(Node nextVal){
        this.pNext = nextVal;
    }

    //非头结点的构造方法
    public Node(Object element, Node nextVal){
        this.element = element;
        this.pNext = nextVal;
    }

    @Override
    public String toString() {
        return
                "element=" + element ;
    }
}
