package com.support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangbingquan
 * @desc 生产者
 * @time 2019-10-21 3:40
 */
@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message){
        kafkaTemplate.send("testTopic",message);
        return true;
    }

    @RequestMapping(value = "/producer",method = RequestMethod.GET)
    public String hello(){
        return "helloworld";
    }
}