package com.zookeeper.support.lock.thread;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangbingquan
 * @version 2019年09月16日
 * @since 2019年09月16日
 **/
@Slf4j
public class DistributeThread extends AbstractLockThread<String> {
    private static final String connectionString = "172.28.51.14:2181";
    //单位是毫秒
    private static final int sessionTimeout = 5000;

    private static ZooKeeper zooKeeper;

    //静态代码块初始化zooKeeper
    static {
        try {
            zooKeeper = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    log.debug("已经触发了" + event.getType() + "事件！");
                    log.debug(event.getPath());
                    log.debug(event.toString());
                    log.debug(event.getState().toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String process() {
        String myZnode = "";
        try {
            Stat stat = zooKeeper.exists("/distributeLock", true);
            if(null == stat) {
                zooKeeper.create("/distributeLock", "distribute-locking-directory".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                myZnode = getLock();
            }else {
                myZnode = getLock();
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return "thread-" + myZnode;
    }

    private static String getLock() throws KeeperException, InterruptedException{
        String myZnode = zooKeeper.create("/distributeLock/lock", "A distribute lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        List<String> list = zooKeeper.getChildren("/distributeLock", false);
        String[] nodes = list.toArray(new String[]{});
        Arrays.sort(nodes);
        if(myZnode.equals("/distributeLock" + "/" +nodes[0])){
            log.debug("当前进程获得分布式锁，执行业务流程");
            log.debug("数据库操作等等需要IO或者耗时的操作集合");
            Thread.sleep(100);
            log.debug("释放分布式锁");
            //注意这里的myZnode就已经是全路径了，不要再添加其他路径
            zooKeeper.delete(myZnode, -1);
            log.debug("释放分布式锁成功，业务操作成功");
        }
        else{
            waitForLock(nodes[0]);
        }
        return myZnode;
    }
    private static void waitForLock(String lower) throws InterruptedException, KeeperException {
        Stat stat = zooKeeper.exists("/distributeLock" + "/" + lower, true);
        if(stat != null){
            // mutex.wait();
            Thread.sleep(200);
        }
        else{
            getLock();
        }
    }
}
