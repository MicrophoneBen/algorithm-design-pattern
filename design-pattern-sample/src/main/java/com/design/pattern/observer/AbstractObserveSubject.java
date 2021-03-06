package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;
/*
 * @author zhangbingquan
 * @desc 建立一种对象与对象之间的依赖关系，一个对象发生改变时将自动通知其他对象，其他对象将相应做出反应。
 * 在此，发生改变的对象称为观察目标，而被通知的对象称为观察者，一个观察目标可以对应多个观察者，
 * 而且这些观察者之间没有相互联系，可以根据需要增加和删除观察者，使得系统更易于扩展，这就是观察者模式的模式动机
 */

/**
 * @author zhangbingquan
 * @desc  观察者模式中的观察目标，动作的发起者，其他的观察者收到动作激活之后，引起时间回调
 * @time 2019-09-14 18:50
 */
public abstract class AbstractObserveSubject {
    /**观察者列表*/
    protected List<Observer> observers = new ArrayList();
    /**添加观察目标的观察者,一般是在抽象类中实现*/
    public abstract void attach(Observer observer);
    /**移除观察目标中观察者列表中的观察者，一般是在抽象类中实现*/
    public abstract void detach(Observer observer);
    /**激活观察者，即观察目标中的事件回调方法*/
    public abstract void ObseverNotify();
}

/*
 * @author zhangbingquan
 * @desc 观察者模式(Observer Pattern)：定义对象间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。
 * 观察者模式又叫做发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式
 * 或从属者（Dependents）模式。观察者模式是一种对象行为型模式
 *
 * 观察者模式描述了如何建立对象与对象之间的依赖关系，如何构造满足这种需求的系统。
 * 这一模式中的关键对象是观察目标和观察者，一个目标可以有任意数目的与之相依赖的观察者，一旦目标的状态发生改变，所有的观察者都将得到通知。
 * 作为对这个通知的响应，每个观察者都将即时更新自己的状态，以与目标状态同步，这种交互也称为发布-订阅(publish-subscribe)。
 * 目标是通知的发布者，它发出通知时并不需要知道谁是它的观察者，可以有任意数目的观察者订阅它并接收通知。
 */
