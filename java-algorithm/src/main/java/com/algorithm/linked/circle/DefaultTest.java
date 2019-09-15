package com.algorithm.linked.circle;

/**
 * @author zhangbingquan
 * @desc 链表的默认测试类
 * @time 2019-09-10 2:03
 */
public class DefaultTest {
    public static void main(String[] args) throws Exception {
        LinkList linkList = new LinkList();
        for (int i =0; i < 10; i++){
            int temp = (int) ((Math.random()*100) % 100);
            linkList.insertEle(i, temp);
            System.out.print(temp + "   ");
        }
        System.out.println();
        linkList.deleteEle(4);
        System.out.println("删除第四个元素之后===================================");
        for(int i = 0; i < linkList.size; i++){
            System.out.print(linkList.getEle(i) + "   ");
        }
    }
}
