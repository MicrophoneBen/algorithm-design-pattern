package com.design.pattern.abstractFactory;

import com.design.pattern.abstractFactory.btn.Button;
import com.design.pattern.abstractFactory.factory.LinuxClientFactory;
import com.design.pattern.abstractFactory.factory.UnixClientFactory;
import com.design.pattern.abstractFactory.factory.WindowClientFactory;
import com.design.pattern.abstractFactory.wordTxt.Text;

/**
 * @author zhangbingquan
 * @desc 抽象工厂模式的测试类
 * @time 2019/7/28 18:52
 */
public class DefaultAbstractFactoryTest {
    public static void main(String[] args) {
        //Widow系统下
        AbstractClientFactory clientFactory = new WindowClientFactory();
        Button btn = clientFactory.createButton();
        Text text = clientFactory.createText();
        btn.click();
        text.display();



        //Linux系统下
        AbstractClientFactory linuxClient = new LinuxClientFactory();
        linuxClient.createButton();
        linuxClient.createText();


        //Unix系统下
        AbstractClientFactory unixClient = new UnixClientFactory();
        unixClient.createButton();
        unixClient.createText();
    }
}
