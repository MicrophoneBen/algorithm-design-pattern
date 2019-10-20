package com.support.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangbingquan
 * @desc 消费之
 * @time 2019-10-21 3:42
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "testTopic")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(message);
    }

}