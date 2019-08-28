package com.algorithm.string;

/**
 * @author zhangbingquan
 * @desc 默认测试方法
 * @time 2019/8/25 1:40
 */
public class DefaultTest {
    public static void main(String[] args) {
        char[] cha1 =  {'c','h','i','n','a'};
        char[] cha2 = {'I',' ','l','o','v','e',' ', 'c','h','i','n','a'};

        MyString string1 = new MyString();
        MyString string2 = new MyString(cha1);
        MyString string3 = new MyString(cha2, 2, 4);
        MyString string4 = new MyString("HelloWorld");
        MyString string5 = new MyString("China");


        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
        System.out.println(string2.compareTo(string5));
    }
}
