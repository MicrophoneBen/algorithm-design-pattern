package com.design.pattern.simpleFactory;

/**
 * @author zhangbingquan
 * @desc 电视机工厂类
 * @time 2019/7/26 21:48
 */
public class TvFactory {
    public TvFactory(){}
    public static Television createTv(String tvname) throws RuntimeException{
        switch (tvname) {
            case "海尔":
                return new HierTV();
            case "海神":
                return new HaishenTv();
            case "海康威视":
                return new HaikungTv();
            default:
                System.out.println("暂时没有这种型号的电视机，请联系管理员添加");
                throw new RuntimeException("设备生产错误");
        }
    }
}
