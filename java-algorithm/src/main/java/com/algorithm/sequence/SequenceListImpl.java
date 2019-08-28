package com.algorithm.sequence;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;

/**
 * @author zhangbingquan
 * @desc 线性表接口实现类
 * @time 2019/7/20 20:42
 */
public class SequenceListImpl extends AbstractSequenceList {
    //设计属性
    private final int defaultize = 10;
    //最大长度
    private int maxSize;
    //当前长度
    private int size;
    //对象数组
    private Object[] objectArray;

    //构造顺序表
    public SequenceListImpl() {
        init(defaultize);
    }

    //构造顺序表,表空间为10
    public SequenceListImpl(int size) {
        init(size);
    }

    //顺序表初始化方法
    private boolean init(Integer size) {
        if (null == size) {
            this.maxSize = defaultize;
            //顺序表属性
            this.size = 0;
            objectArray = new Object[size];
            return true;
        } else if (size > 0) {
            this.maxSize = size;
            //顺序表属性
            this.size = 0;
            objectArray = new Object[size];
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean insertEle(int index, Object obj) throws InsertException {
        //线性表已经满
        if (size == maxSize) {
            throw new InsertException(1001, "顺序表已经满，插入失败");
        }
        //插入位置不存在
        if (index < 0 || index > size) {
            throw new InsertException(1002, "元素下标不合法，插入失败");
        }
        //移动元素
        for (int j = size; j > index; j--) {
            objectArray[j] = objectArray[j - 1];
        }
        //当index为0，上循环不会发生，会插入，不为0也会插入
        objectArray[index] = obj;
        //表元素数目加一
        size++;
        return true;
    }

    @Override
    public boolean deleteEle(int index) throws DeleteException {
        if (isEmpty()) {
            throw new DeleteException(1003, "表为空，无法删除");
        }
        //删除下标错误
        if (index < 0 || index > size) {
            throw new DeleteException(1004, "下标不存在，删除失败");
        }
        //移动元素
        for (int j = index; j < size - 1; j++) {
            objectArray[j] = objectArray[j + 1];
        }
        //下标减一
        size--;
        return true;
    }

    @Override
    public Object getEle(int index) {
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        //非法下标
        if (index < 0 || index > size) {
            throw new RuntimeException("元素查找失败，元素不存在");
        }
        return objectArray[index];
    }

    @Override
    public boolean updateEle(int index, Object obj) throws UpdateException {
        if (isEmpty()) {
            throw new UpdateException(1000, "顺序表为空");
        }
        //下标不合法,下标等于size元素为空
        if (index < 0 || index >= size) {
            throw new UpdateException(1005, "元素不存在，更新失败");
        }
        objectArray[index] = obj;
        return true;
    }
}
