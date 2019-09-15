package com.zookeeper.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author zhangbingquan
 * @desc Zookeeper的节点基本操作方法类
 * @time 2019-09-16 0:15
 */
@Slf4j
public class BaseZkOprate {
    private static final String connectionString = "192.168.1.104:2181";
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

    public static void main(String[] args) throws KeeperException, InterruptedException {
        // 创建一个目录节点
        zooKeeper.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zooKeeper.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zooKeeper.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
        System.out.println(zooKeeper.getChildren("/testRootPath",true));
        // 修改子目录节点数据
        zooKeeper.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
        System.out.println("目录节点状态：["+zooKeeper.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
        zooKeeper.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zooKeeper.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
        zooKeeper.delete("/testRootPath/testChildPathTwo",-1);
        zooKeeper.delete("/testRootPath/testChildPathOne",-1);
        // 删除父目录节点
        zooKeeper.delete("/testRootPath",-1);
        // 关闭连接
        zooKeeper.close();

    }
}
