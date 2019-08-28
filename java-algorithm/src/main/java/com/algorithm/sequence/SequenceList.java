package com.algorithm.sequence;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;

/**
 * @author zhangbingquan
 * @desc 线性表接口
 * @time 2019/7/20 19:27
 */
public interface SequenceList {
    //获得线性表的长度
    public int getSize();

    //判断线性表是否为空
    public boolean isEmpty();

    //插入元素
    public boolean insertEle(int index, Object obj) throws InsertException;

    //删除元素
    public boolean deleteEle(int index) throws DeleteException;

    //查找元素
    public Object getEle(int index);

    //更新元素
    public boolean updateEle(int index, Object obj) throws UpdateException;
}
