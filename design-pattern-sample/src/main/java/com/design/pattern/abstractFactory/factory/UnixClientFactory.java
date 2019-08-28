package com.design.pattern.abstractFactory.factory;

import com.design.pattern.abstractFactory.AbstractClientFactory;
import com.design.pattern.abstractFactory.btn.Button;
import com.design.pattern.abstractFactory.btn.UnixButton;
import com.design.pattern.abstractFactory.wordTxt.Text;
import com.design.pattern.abstractFactory.wordTxt.UnixText;

/**
 * @author zhangbingquan
 * @desc Unix系统下的客户端工具类，用来生产用于Unix系统下的客户端工具显示
 * @time 2019/7/28 18:48
 */
public class UnixClientFactory extends AbstractClientFactory {
    @Override
    public Button createButton() {
        System.out.println("Unix系统下,点击按钮");
        return new UnixButton();
    }

    @Override
    public Text createText() {
        System.out.println("Unix系统下，显示文字的框");
        return new UnixText();
    }
}
