package com.design.pattern.listener;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangbingquan
 * @desc 事件接口的实现类
 * @time 2019/8/20 1:27
 */
@Data
public class MyEvent implements Event {
    private static final Logger logger = LoggerFactory.getLogger(MyEvent.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private Object source;

    private Date when;

    private String message;

    @Override
    public Object getSource() {
        return source;
    }

    @Override
    public Date getWhen() {
        return when;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void callBack() {
        logger.info(toString());
    }


}
