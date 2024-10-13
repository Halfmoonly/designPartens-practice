package org.lyflexi.proxy.dynamic_proxy_jdk.mapper;

public class OtherMapperImpl {

    public int delete(int id){
        System.out.println("OtherMapperImpl Deleting user with ID: " + id);
        return 1; // 模拟删除成功
    }
}
