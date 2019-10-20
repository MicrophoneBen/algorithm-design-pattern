package com.support.entity.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangbingquan
 * @desc Kafka的发送消息实体类
 * @time 2019-10-20 23:39
 */
@Data
public class MsgEntity<T> {
    private Long id;    //id

    private T msg; //消息

    private Date sendTime;  //时间戳


}
