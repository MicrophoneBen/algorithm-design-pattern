package com.support.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * @author zhangbingquan
 * @desc
 * @time 2019-10-21 3:33
 */

@Component
public class RawDataListener {
    Logger logger=Logger.getLogger(RawDataListener.class);

    /**
     * 实时获取kafka数据(生产一条，监听生产topic自动消费一条)
     * @param record
     * @throws IOException
     */
    @KafkaListener(topics = {"${kafka.consumer.topic}"})
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        String value = (String) record.value();
        System.out.println(value);
    }

}