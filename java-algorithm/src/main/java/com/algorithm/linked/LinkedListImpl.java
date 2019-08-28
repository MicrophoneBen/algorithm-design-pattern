package com.algorithm.linked;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;

/**
 * @author zhangbingquan
 * @desc 链表接口实现类
 * @time 2019/7/21 23:08
 */
public class LinkedListImpl extends AbstractLinkedList {
    //定位函数，定位到操作节点的前一个节点
    public Node preIndex(int index) throws RuntimeException {
        if (index < -1 || index > size - 1) {
            throw new RuntimeException("下标参数错误");
        }
        //说明在头结点之后操作
        if (index == -1) {
            return this.head;
        }
        current = head.next;
        //循环变量
        int j = 0;
        while (current != null && j < index) {
            current = current.next;
            j++;
        }
        return current;
    }

    public void index(int index) throws RuntimeException {
        if (index < -1 || index > size - 1) {
            throw new RuntimeException("下标参数错误,无法定位到前一个节点");
        }
        //说明在头结点之后操作
        if (index == -1) {
            return;
        }
        current = head.next;
        //循环变量
        int j = 0;
        while (current != null && j < index) {
            current = current.next;
            j++;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean insertEle(int index, Object obj) throws InsertException {
        if (index < 0 || index > size) {
            throw new InsertException(1001, "插入失败，节点下标不正确");
        }
        //定位到前一个节点
        index(index - 1);
        current.setNext(new Node(obj, current.next));
        //链表元素数目加一
        size++;
        return true;
    }

    public boolean insertNode(int index, Node node) {
        if (index < -1 || index > size) {
            throw new InsertException(1001, "插入失败，节点下标不正确");
        }
        //新节点指针域挂之后的链表
        node.setNext(this.current);
        //定位当前节点的前一个节点
        Node pre = preIndex(index);
        //把当前节点挂载到前一个节点后面
        pre.setNext(node);
        return true;
    }

    @Override
    public boolean deleteEle(int index) throws DeleteException {
        if(isEmpty()){
            throw new DeleteException(1002, "删除异常，链表为空");
        }
        if(index < 0 || index > size){
            throw new DeleteException(1003, "下标参数错误，删除失败");
        }
        //定位
        index(index-1);
        //删除当前节点
        current.setNext(current.next.next);
        size--;
        return true;
    }

    @Override
    public Object getEle(int index) {
        if(index < 0 || index > size-1){
            throw new RuntimeException("节点不存在，下标参数错误");
        }
        /*
        current = head.next;
        //循环变量
        int j = 0;
        while (current != null && j < index) {
            current = current.next;
            j++;
        }
        assert current != null;
        if (current.element != null){
        return current.getElement();
        }else {
            return "空数据";
        }
        */
        //定位
        index(index);
        return current.getElement();
    }

    @Override
    public boolean updateEle(int index, Object obj) throws UpdateException {
        index(index);
        current.setElement(obj);
        return true;
    }
}
