package org.lyflexi.proxy.dynamic_proxy_jdk_v1.service;

public class TestServiceImpl implements ITestService {

    @Override
    public int delete(int id){
        System.out.println("TestServiceImpl Deleting user with ID: " + id);
        return 1; // 模拟删除成功
    }
}
