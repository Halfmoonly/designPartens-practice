package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.proxy.MyInvocationHandler;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.OtherUnsatisfiedImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.ITestService;

import org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.TestServiceImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.IMyService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyServiceImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v3.proxy.MapperProxyFactory;

import java.lang.reflect.Proxy;

public class DynamicProxyJdkV1Test {

    @Test
    public void testProxy() {
        // 创建目标对象
        ITestService target = new TestServiceImpl();

        // 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 设置目标接口类型，并创建代理对象
        ITestService proxy = (ITestService) Proxy.newProxyInstance(
                ITestService.class.getClassLoader(),  // 类加载器
                new Class[]{ITestService.class},     // 接口列表
                handler                           // InvocationHandler
        );

        // 通过代理对象调用方法
        proxy.delete(1);

    }

    /**
     * java.lang.IllegalArgumentException: object is not an instance of declaring class
     *
     * OtherMapperImpl并没有实现ITestService接口
     */
    @Test
    public void testUnmatchedProxy1() {
        // 创建目标对象
        OtherUnsatisfiedImpl target = new OtherUnsatisfiedImpl();
        // 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 设置目标接口类型，并创建代理对象
        ITestService proxy = (ITestService) Proxy.newProxyInstance(
                ITestService.class.getClassLoader(),  // 类加载器
                new Class[]{ITestService.class},     // 接口列表
                handler                           // InvocationHandler
        );

        // 目标接口类型ITestService，与目标对象target类型不匹配，代理方法执行异常
        proxy.delete(1);
    }

    /**
     * java.lang.ClassCastException:
     * class jdk.proxy2.$Proxy4 cannot be cast to class org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.OtherUnsatisfiedImpl (jdk.proxy2.$Proxy4 is in module jdk.proxy2 of loader 'app'; org.lyflexi.proxy.dynamic_proxy_jdk_v1.service.OtherUnsatisfiedImpl is in unnamed module of loader 'app')
     *
     * OtherMapperImpl并没有实现ITestService接口
     */
    @Test
    public void testUnmatchedProxy2() {
        // 创建目标对象
        OtherUnsatisfiedImpl target = new OtherUnsatisfiedImpl();
        // 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 设置目标接口类型，并创建代理对象
        OtherUnsatisfiedImpl proxy = (OtherUnsatisfiedImpl) Proxy.newProxyInstance(
                ITestService.class.getClassLoader(),  // 类加载器
                new Class[]{ITestService.class},     // 接口列表
                handler                           // InvocationHandler
        );

        // 目标接口类型ITestService，与目标对象target类型不匹配，代理方法执行异常
        proxy.delete(1);
    }
}
