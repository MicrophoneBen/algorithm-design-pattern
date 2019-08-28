package com.algorithm.linked;

/**
 * @author zhangbingquan
 * @desc 链表节点类
 * @time 2019/7/21 22:43
 */
public class Node {
    //数据域
    Object element;
    //指针域
    Node next;

    //头结点的构造方法
    Node(Node nextVal){
        this.next = nextVal;
    }

    //非头结点的构造方法
    Node(Object object, Node nextVal){
        this.element = object;
        this.next = nextVal;
    }

    //获取当前节点的后继节点
    public Node getNext(){
        return this.next;
    }

    //获取当前数据域的值
    public Object getElement(){
        return this.element;
    }

    //设置节点的值
    public boolean setElement(Object elementVal){
        this.element = elementVal;
        return true;
    }

    //设置节点的指针域
    public  void setNext(Node nextVal){
        this.next = nextVal;
    }

    public String toString(){
        return  this.element.toString();
    }
}
