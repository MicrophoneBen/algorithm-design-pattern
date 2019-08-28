package com.design.pattern.singleton;

/**
 * @author zhangbingquan
 * @desc 单实例的全局号码生成
 * @time 2019/7/30 22:45
 */
public class IdentityCardNo
{
    private static IdentityCardNo instance=null;
    private String no;
    private IdentityCardNo(){
    }
    synchronized static IdentityCardNo getInstance(){
        if(instance==null){
            System.out.println("第一次办理身份证，分配新号码！");
            instance=new IdentityCardNo();
            //定义一个生成号码的随机数算法
            instance.setIdentityCardNo("No400011112222");
        }
        else{
            System.out.println("重复办理身份证，获取旧号码！");
            //数据库查询获取。
        }
        return instance;
    }
    private void setIdentityCardNo(String no){
        this.no=no;
    }
    String getIdentityCardNo(){
        return this.no;
    }
}
