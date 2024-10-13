package org.lyflexi.proxy.dynamic_proxy_jdk_v1.service;

public class OtherUnsatisfiedImpl {

    public int delete(int id){
        System.out.println("OtherUnsatisfiedImpl Deleting user with ID: " + id);
        return 1; // 模拟删除成功
    }
}
