### JDK的线程池
 java 线程池的顶级接口是 Executor, 只定义了一个方法 execute，ExecutorService继承接口Executor接口，
 并定义了其他的相关的接口，ExecutorService下面有一个继承的抽象类AbstractExecutorService
 和实现了定时调度的接口ScheduledExecutorService，而又有两个类继承抽象类，
 分别是ThreadPoolExecutor和ForkJoinPool，
 而ScheduledThreadPoolExecutor则实现接口实现ScheduledExecutorService接口和继承ThreadPoolExecutor类，
 基本的关系就是这样的，而且基本常用的封装方法都在Executors类中，
 只要 Executors.xxxx 就可以应用对应的封装的方法。
![](https://img-blog.csdnimg.cn/20190129152135834.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDI4NjIz,size_16,color_FFFFFF,t_70)

### 线程类concurrent
在包concurrent包下面的类的关系，里面包括线程池相关的类和线程安全相关的类等，当然还包括lock锁，具体如下：
![](https://img-blog.csdnimg.cn/20190129154850550.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4NDI4NjIz,size_16,color_FFFFFF,t_70)

