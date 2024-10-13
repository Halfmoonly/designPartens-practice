package org.lyflexi.proxy;


import org.junit.Test;

import org.lyflexi.proxy.dynamic_proxy_jdk_v2.proxy.MyInvocationHandler;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyServiceImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyJdkV2Test {

    @Test
    public void testProxy() {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建目标对象
        MyService target = new MyServiceImpl();

        // 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 创建代理对象
        MyService proxy = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),  // 类加载器
                new Class[]{MyService.class},     // 接口列表
                handler                           // InvocationHandler
        );

        // 通过代理对象调用方法
        proxy.doSomething();

        System.out.println(System.getProperty("java.io.tmpdir"));

    }


}
