package org.lyflexi.proxy.dynamic_proxy_jdk.mapper;

public class UserMapperImpl implements UserMapper{

    @Override
    public int delete(int id){
        System.out.println("Deleting user with ID: " + id);
        return 1; // 模拟删除成功
    }
}
