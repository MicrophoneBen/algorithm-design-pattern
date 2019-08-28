package com.algorithm.sequence;

import com.algorithm.exception.DeleteException;
import com.algorithm.exception.InsertException;
import com.algorithm.exception.UpdateException;

/**
 * @author zhangbingquan
 * @desc 线性表接口抽象实现类
 * @time 2019/7/20 20:44
 */
public abstract class AbstractSequenceList implements SequenceList {
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
