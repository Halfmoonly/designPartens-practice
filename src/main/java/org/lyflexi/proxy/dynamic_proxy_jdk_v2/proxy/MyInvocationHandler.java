package org.lyflexi.proxy.dynamic_proxy_jdk_v2.proxy;

import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/10/13 22:53
 */

// 自定义的 InvocationHandler
public class MyInvocationHandler implements InvocationHandler {
    private final MyService target;

    public MyInvocationHandler(MyService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}