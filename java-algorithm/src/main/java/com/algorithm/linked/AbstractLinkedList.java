package com.algorithm.linked;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;

/**
 * @author zhangbingquan
 * @desc 链表抽象类
 * @time 2019/7/21 23:07
 */
public abstract class AbstractLinkedList implements LinkedList {
    //头指针
    Node head;
    //当前节点对象
    Node current;
    //节点个数
    int size;

    //初始化一个空链表
    public AbstractLinkedList() {
        //初始化头结点，让头指针指向头结点，并且让当前节点对象等于头结点
        this.head = this.current = new Node(null);
        //单链表初始化，长度为0
        this.size = 0;
    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean insertEle(int index, Object obj) throws InsertException {
        return false;
    }

    @Override
    public boolean deleteEle(int index) throws DeleteException {
        return false;
    }

    @Override
    public Object getEle(int index) {
        return null;
    }

    @Override
    public boolean updateEle(int index, Object obj) throws UpdateException {
        return false;
    }
}
