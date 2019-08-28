package com.design.pattern.builder.product;

/**
 * @author zhangbingquan
 * @desc 面包建造者对象，制作各种面包糕点
 * @time 2019/7/28 21:52
 * @learning 在接口中声明抽象方法由继承方法的类实现可以不使用abstract关键字声明方法
 * 但是在抽象方法中，只有两种方法的书写形式，要么就实现这个方法，要么就加上abstract关键字
 */
public abstract class AbstractPastryBuilder {

    //protected 作用域，这个成员变量传递给子类，仅限子类进行使用
    protected Pastry pastry = new Pastry();

    //生产糕点所需要的奶油对象
    public abstract boolean createPastryCream();

    //出厂时打上出厂日期
    public abstract void produceTimeTag();

    //购买糕点所需要的鸡蛋
    public abstract void buyEgg();

    //购买生产糕点所使用的水
    public abstract void buyWater();

    //生产的糕点的名字
    public abstract void setPastryName();

    public Pastry getPastry() {
        return pastry;
    }

}
