package com.design.pattern.singleton;

import org.junit.jupiter.api.Test;

/**
 * @author zhangbingquan
 * @desc 身份证号码生成单例的客户端实例
 * @time 2019/7/30 22:46
 */
public class Client{
    public static void main(String a[]){
        IdentityCardNo no1,no2;
        no1=IdentityCardNo.getInstance();
        no2=IdentityCardNo.getInstance();
        System.out.println("身份证号码是否一致：" + (no1==no2));

        String str1,str2;
        str1=no1.getIdentityCardNo();
        str2=no1.getIdentityCardNo();
        System.out.println("第一次号码：" + str1);
        System.out.println("第二次号码：" + str2);
        System.out.println("内容是否相等：" + str1.equalsIgnoreCase(str2));
        System.out.println("是否是相同对象：" + (str1==str2));

        getFreeMemory();
    }

    @Test
    public static void getFreeMemory() {
        //获取可用内存
        long value = Runtime.getRuntime().freeMemory();
        System.out.println("可用内存为:"+value/1024/1024+"mb");
        //获取jvm的总内存数量，该值会不断的变化
        long  totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("全部内存为:"+totalMemory/1024/1024+"mb");
        //获取jvm 可以最大使用的内存数量，如果没有被限制 返回 Long.MAX_VALUE;
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("可用最大内存为:"+maxMemory/1024/1024+"mb");
    }
}
