package com.design.pattern.adapter;

import com.design.pattern.adapter.adaptee.BirdAdapter;
import com.design.pattern.adapter.adaptee.ObjectBirdAdapter;

/**
 * @author zhangbingquan
 * @desc 适配器客户端使用
 * @time 2019/8/18 22:15
 */
public class Client {
    public static void main(String[] args) {
           Robot robot = new BirdAdapter();

           robot.move();
           robot.cry();


           Robot birdRobot = new ObjectBirdAdapter();
           birdRobot.move();
           birdRobot.cry();
    }
}
