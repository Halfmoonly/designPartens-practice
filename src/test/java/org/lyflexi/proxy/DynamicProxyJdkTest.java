package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_jdk.mapper.OtherMapperImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_jdk.mapper.UserMapperImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk.proxy.MapperProxy;
import org.lyflexi.proxy.dynamic_proxy_jdk.proxy.MapperProxyFactory;

public class DynamicProxyJdkTest {

    @Test
    public void testProxy() {
        // 代理实例工厂
        MapperProxyFactory proxyFactory = new MapperProxyFactory(UserMapper.class);

        // 代理逻辑处理handler
        MapperProxy userMapperProxy = new MapperProxy(new UserMapperImpl());


        // 获取代理对象
        UserMapper userMapper = (UserMapper) proxyFactory.newInstance(userMapperProxy);

        int delete = userMapper.delete(1);
        System.out.println("result = " + delete);

    }

    /**
     * java.lang.IllegalArgumentException: object is not an instance of declaring class
     *
     * OtherMapperImpl并没有实现UserMapper接口
     */
    @Test
    public void testOtherMapper() {
        // 代理实例工厂
        MapperProxyFactory proxyFactory = new MapperProxyFactory(UserMapper.class);

        // 代理逻辑处理handler
        MapperProxy otherMapperProxy = new MapperProxy(new OtherMapperImpl());


        // 获取代理对象
        UserMapper otherMapper = (UserMapper) proxyFactory.newInstance(otherMapperProxy);

        int delete = otherMapper.delete(1);
        System.out.println("result = " + delete);

    }
}
