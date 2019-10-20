package com.support.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.support.entity.kafka.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhangbingquan
 * @desc KafKa生产者
 * @time 2019-10-21 2:42
 */

@Component
@Slf4j
public class KafkaProducerSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send() {
        MsgEntity<String> message = new MsgEntity<>();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", JSONObject.toJSON(message));
        kafkaTemplate.send("uuid-queue-msg", JSONObject.toJSONString(message));
    }
}