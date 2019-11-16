package com.thread.detail.threadUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangbingquan
 * @version 2019年09月07日
 * @since 2019年09月07日
 **/
public class HttpThread extends AbstractHttpThread<List<Map<String, Object>>> implements Callable<List<Map<String, Object>>> {
    private String taskType;
    private String username;
    private CountDownLatch countDownLatch;

    public HttpThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public List<Map<String, Object>> process() {
        return null;
    }
}
