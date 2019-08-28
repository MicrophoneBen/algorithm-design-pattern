package com.design.pattern.listener;

import com.design.pattern.listener.handler.MyListener;
import com.design.pattern.listener.source.MySource;

/**
 * @author zhangbingquan
 * @desc 默认的本地测试类
 * @time 2019/8/23 0:50
 */
public class DefaultMainTest {
    public static void main(String[] args) {
        MySource source = new MySource();
        source.addListener(new MyListener());
        source.setValue(100);
    }
}
