package org.lyflexi.proxy;


import org.junit.Test;

import org.lyflexi.proxy.dynamic_proxy_jdk_v2.proxy.GeneralInvocationHandler;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.IMyService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyServiceImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyJdkV2Test {

    @Test
    public void testProxy() {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建目标对象
        IMyService target = new MyServiceImpl();

        // 创建 InvocationHandler
        GeneralInvocationHandler handler = new GeneralInvocationHandler(target);

        // 创建代理对象
        IMyService proxy = (IMyService) Proxy.newProxyInstance(
                IMyService.class.getClassLoader(),  // 类加载器
                new Class[]{IMyService.class},     // 接口列表
                handler                           // InvocationHandler
        );

        // 通过代理对象调用方法
        proxy.doSomething();

        System.out.println(System.getProperty("java.io.tmpdir"));

    }


}
