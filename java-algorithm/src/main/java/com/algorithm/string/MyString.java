package com.algorithm.string;

/**
 * @author zhangbingquan
 * @desc 字符串类
 * @time 2019/8/25 1:03
 */
public class MyString {
    /*
     * @author zhangbingquan
     * @desc 存放字符串的字符数组
     * @time 2019/8/25 1:05
     */
    private char[] value;

    /*
     * @author zhangbingquan
     * @desc 字符串的长度
     * @time 2019/8/25 1:06
     */
    private int count;

    //构造方法， 构造一个空字符串
    public MyString(){
        value = new char[0];
        count = 0;
    }
    //构造方法， 实现一个字符串的拷贝(从一个字符串中提取出所需要的字符串)
    //count 是拷贝的个数
    public MyString(char[] src, int offset, int count){
        if(offset < 0 || offset > src.length){
            throw new StringIndexOutOfBoundsException("offset 越过数组index");
        }
        if(count < 0){
            throw new StringIndexOutOfBoundsException("截取字符串的长度不符合需求");
        }
        if(offset + count > src.length){
            throw new StringIndexOutOfBoundsException("offet + conut 越界异常");
        }
        this.value = new char[count];
        this.count = count;
        arrayCopy(src, offset, this.value, 0, count);
    }
    private static boolean arrayCopy(char[] src, int srcPos, char[] dest, int destPos, int length){
        //判断参数是否有误
        if(srcPos + length > src.length ||  destPos + length > dest.length){
            throw  new StringIndexOutOfBoundsException("字符串拷贝参数输入有误，无法完成拷贝");
        }
        for(int i = 0; i < length; i++){
            dest[destPos++] = src[srcPos++];
        }
        return true;
    }

    //构造方法，根据已有的字符串数组构造新的字符串
    public MyString(char[] src){
        this.count = src.length;
        this.value = new char[count];
        arrayCopy(src, 0,this.value, 0, count);
    }

    //构造方法使用JDK本身的String类，构造新的字符串
    public MyString(String s){
        char[] chars = s.toCharArray();
        this.value = chars;
        this.count = chars.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (char c : this.value) {
            str.append(c);
        }
        return str.toString();
    }

    public int lenght(){
        return this.count;
    }

    public char charAt(int index){
        if(index<0 || index>count){
            throw new StringIndexOutOfBoundsException("字符下标index不存在" + index);
        }
        return value[index];
    }

    /**
     * @desc 比较两个字符串的大小，
     * 1. 如果当前字符串大于比较字符串，返回一个正整数
     * 2. 如果当前字符串等于比较字符串，返回0
     * 3. 如果当前字符串小于比较字符串，返回负整数
     * @time 2019/8/25 2:05
     */
    public int compareTo(MyString anotherString){
        int srclen = this.count;
        int deslen = anotherString.count;
        int n = Math.min(srclen, deslen);
        char[] v1 = this.value;
        char[] v2 = anotherString.value;
        int i = 0;
        while(i < n){
            char c1 =  v1[i];
            char c2 = v2[i];
            if(c1 != c2){
                return c1 - c2;
            }
            i++;
        }
        return srclen - deslen;
    }
}
