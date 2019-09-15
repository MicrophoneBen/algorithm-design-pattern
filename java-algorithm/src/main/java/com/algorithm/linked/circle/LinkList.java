package com.algorithm.linked.circle;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;
import lombok.Data;

/**
 * @author zhangbingquan
 * @desc 单向链表类
 * @time 2019-09-10 1:33
 */
@Data
public class LinkList implements LinkedList{
    /**
     * @desc 头指针
     */
    Node head;
    /**
     * @desc 当前节点对象
     */
    Node current;

    //节点个数
    int size;

    //初始化一个空链表
    public LinkList(){
        //初始化一个头结点，让头指针指向头结点，并且让当前节点对象等于头结点
        this.head = current = new Node(null);
        //单链表，初始长度为0
        this.size = 0;
    }

    //实现当前操作对象的前一个节点的定位操作，定位到操作节点的前一个节点
    public void getPreIndex(int index)throws Exception{
        //链表的首元节点为0，最大长度是size
        if(index < -1 || index > size -1){
            throw new Exception("下标参数不合法");
        }
        if(index == -1){
            return;
        }
        current = head.pNext;
        int j = 0;   //循环变量
        while(current != null && j < index){
            current = current.pNext;
            j++;
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean insertEle(int index, Object obj) throws Exception {
        if(index < 0 || index > size){
            throw new InsertException(10001, "参数错误");
        }
        //定位到前一个节点
        getPreIndex(index - 1);
        current.setPNext(new Node(obj, current.getPNext()));
        size ++;
        return true;

    }

    @Override
    public boolean deleteEle(int index) throws Exception {
        //判空
        if(isEmpty()){
            throw new DeleteException(10002, "链表为空无法删除");
        }
        //参数是否合法
        if(index < 0 || index > size){
            throw new DeleteException(10001, "参数错误");
        }
        getPreIndex(index-1);
        current.setPNext(current.getPNext().getPNext());
        size --;
        return true;
    }

    @Override
    public Object getEle(int index) throws Exception {
        //判空
        if(isEmpty()){
            throw new InsertException(10002, "链表为空无法删除");
        }
        //参数是否合法
        if(index < 0 || index > size){
            throw new InsertException(10001, "参数错误");
        }
        getPreIndex(index);
        return current.getElement();
    }

    @Override
    public boolean updateEle(int index, Object obj) throws Exception {
        //判空
        if(isEmpty()){
            throw new InsertException(10002, "链表为空无法删除");
        }
        //参数是否合法
        if(index < 0 || index > size){
            throw new InsertException(10001, "参数错误");
        }
        getPreIndex(index-1);
        current.setPNext(new Node(obj, current.getPNext()));
        return true;
    }
}
