package com.thread.pool;

import com.thread.pool.base.CallableTemplate;
import com.thread.pool.frameWork.CallableTaskFrameWork;
import com.thread.pool.frameWork.ICallableFrameWork;
import com.thread.pool.service.SendMessageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangbingquan
 * @desc 单元测试
 * @time 2019-09-13 1:10
 */
public class DefaultTheadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ICallableFrameWork callableTaskFrameWork = new CallableTaskFrameWork();
        List<CallableTemplate<Map<String, String>>> tasks = new ArrayList<>();
        SendMessageHandler sendMessageHander = null;
        // 将需要发送邮件的邮件地址及内容组装好，放在一个集合中
        for (int i = 0; i < 1000; i++) {
            sendMessageHander = new SendMessageHandler("email" + i, "content" + i);
            tasks.add(sendMessageHander);
        }
        //通过多线程一次性发起邮件，并拿到返回结果集
        List<Map<String, String>> results = callableTaskFrameWork.submitAll(tasks);
        // 解析返回结果集
        for (Map<String, String> map : results) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
        ((CallableTaskFrameWork) callableTaskFrameWork).closeAll();
    }
}
