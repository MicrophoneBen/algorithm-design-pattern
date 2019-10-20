package com.support.entity.kafka;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangbingquan
 * @desc Kafka消息
 * @time 2019-10-21 3:43
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    /**
     * transient 关键字修饰的字段不会被序列化
     */
    private transient String desc;
}
