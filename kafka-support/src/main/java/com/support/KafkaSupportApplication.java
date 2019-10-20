package com.support;

import com.support.kafka.KafkaProducer;
import com.support.kafka.KafkaProducerSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * @author zhangbingquan
 * @version 2019年09月18日
 * @since 2019年09月18日
 **/
@SpringBootApplication
@Slf4j
@ComponentScan("com.support.kafka")
@EnableKafka
public class KafkaSupportApplication {
    public static void main(String[] args) {
     SpringApplication.run(KafkaSupportApplication.class, args);
    }
}
