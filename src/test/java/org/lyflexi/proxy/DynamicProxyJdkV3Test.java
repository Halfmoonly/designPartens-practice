package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.OtherUnsatisfiedImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.ITestService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.TestServiceImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v3.mapper.AccountMapper;
import org.lyflexi.proxy.dynamic_proxy_jdk_v3.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_jdk_v3.proxy.MapperProxy;
import org.lyflexi.proxy.dynamic_proxy_jdk_v3.proxy.MapperProxyFactory;


public class DynamicProxyJdkV3Test {

    @Test
    public void testProxy() {
        // 代理逻辑处理handler，如果用不到目标对象method.invoke(target.args)，则可以给target对象赋空
        MapperProxy nonTargetProxy = new MapperProxy(null);




        // 代理实例工厂
        MapperProxyFactory<UserMapper> userMapperProxyFactory = new MapperProxyFactory(UserMapper.class);
        // 获取代理对象, 如果
        UserMapper userMapper = (UserMapper) userMapperProxyFactory.newInstance(nonTargetProxy);
        userMapper.deleteUser(1);
        userMapper.getUser(1);
        System.out.println("-------------------------------------------");
        // 代理实例工厂
        MapperProxyFactory<AccountMapper> accountMapperProxyFactory = new MapperProxyFactory(AccountMapper.class);
        // 获取代理对象, 如果
        AccountMapper accountMapper = (AccountMapper) accountMapperProxyFactory.newInstance(nonTargetProxy);
        accountMapper.deleteAccount(1);
        accountMapper.getAccount(1);

    }

}
