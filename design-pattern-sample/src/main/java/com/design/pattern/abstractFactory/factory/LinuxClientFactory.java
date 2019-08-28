package com.design.pattern.abstractFactory.factory;

import com.design.pattern.abstractFactory.AbstractClientFactory;
import com.design.pattern.abstractFactory.btn.Button;
import com.design.pattern.abstractFactory.btn.LinuxButton;
import com.design.pattern.abstractFactory.wordTxt.LinuxText;
import com.design.pattern.abstractFactory.wordTxt.Text;

/**
 * @author zhangbingquan
 * @desc Linux系统下的工厂实现类，用来生产适用于Linux系统客户端的页面工具
 * @time 2019/7/28 18:46
 */
public class LinuxClientFactory extends AbstractClientFactory {
    @Override
    public Button createButton() {
        System.out.println("Linux系统下，Linux客户端按钮");
        return new LinuxButton();
    }

    @Override
    public Text createText() {
        System.out.println("Linux系统下，Linux客户端文本显示框");
        return new LinuxText();
    }
}
