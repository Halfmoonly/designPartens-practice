package org.lyflexi.proxy.dynamic_proxy_jdk_v2;

import org.lyflexi.proxy.dynamic_proxy_jdk_v2.proxy.GeneralInvocationHandler;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.IMyService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyServiceImpl;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.IOtherService;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.OtherServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/10/13 23:00
 */
public class Main {
    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建目标对象
        IMyService target1 = new MyServiceImpl();
        // 创建 InvocationHandler
        GeneralInvocationHandler handler1 = new GeneralInvocationHandler(target1);

        // 创建代理对象
        IMyService proxy1 = (IMyService) Proxy.newProxyInstance(
                IMyService.class.getClassLoader(),  // 类加载器
                new Class[]{IMyService.class},     // 接口列表
                handler1                           // InvocationHandler
        );
        // 通过代理对象调用方法
        proxy1.doSomething();

        // 创建目标对象
        IOtherService target2 = new OtherServiceImpl();
        // 创建 InvocationHandler
        GeneralInvocationHandler<IOtherService> handler2 = new GeneralInvocationHandler<IOtherService>(target2);
        // 创建代理对象
        IOtherService proxy2 = (IOtherService) Proxy.newProxyInstance(
                IOtherService.class.getClassLoader(),  // 类加载器
                new Class[]{IOtherService.class},     // 接口列表
                handler2                          // InvocationHandler
        );
        // 通过代理对象调用方法
        proxy2.doOtherthing();
    }
}
