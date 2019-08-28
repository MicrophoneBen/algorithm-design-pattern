package com.design.pattern.abstractFactory;

import com.design.pattern.abstractFactory.btn.Button;
import com.design.pattern.abstractFactory.wordTxt.Text;

/**
 * @author zhangbingquan
 * @desc 抽象的客户端工厂类，提供外部使用工厂生产对象的接口
 * @time 2019/7/28 18:29
 */
public abstract class AbstractClientFactory {
    public abstract Button  createButton();
    public abstract Text createText();
}
