package com.support.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author zhangbingquan
 * @desc Kafka项目启动的配置文件
 * @time 2019-10-20 23:24
 */
@Data
public class KafkaConfig {
    @Value("${kafka.bootstrap.servers}")
    private String kafkaServer;

    @Value("${kafka.batch.size}")
    private String commitBatchSize;

    @Value("${kafka.linger.ms}")
    private String commitLingerWait;

    @Value("${kafka.buffer.memory}")
    private String commitBuffer;

    public void kafkaConfig() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaServer);
        properties.put("acks", "all");
        properties.put("retries", 3);
        properties.put("batch.size", commitBatchSize);
        properties.put("linger.ms", commitLingerWait);
        properties.put("buffer.memory", commitBuffer);

    }
}
