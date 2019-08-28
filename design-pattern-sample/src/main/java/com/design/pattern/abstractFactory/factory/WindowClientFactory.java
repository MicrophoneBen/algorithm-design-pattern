package com.design.pattern.abstractFactory.factory;

import com.design.pattern.abstractFactory.AbstractClientFactory;
import com.design.pattern.abstractFactory.btn.Button;
import com.design.pattern.abstractFactory.btn.WindowButton;
import com.design.pattern.abstractFactory.wordTxt.Text;
import com.design.pattern.abstractFactory.wordTxt.WindowText;

/**
 * @author zhangbingquan
 * @desc window系统下的工具类，生产一个系列的产品类，生产的是window系统适配的产品类
 * @time 2019/7/28 18:43
 */
public class WindowClientFactory extends AbstractClientFactory {
    @Override
    public Button createButton() {
        System.out.println("Window系统下，Window点击按钮");
        return new WindowButton();
    }

    @Override
    public Text createText() {
        System.out.println("Window系统下，Window文本框显示");
        return new WindowText();
    }
}
