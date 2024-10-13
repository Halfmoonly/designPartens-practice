package org.lyflexi.proxy.static_proxy.proxy;

import org.lyflexi.proxy.static_proxy.service.lawsuit.ILawsuit;
import org.lyflexi.proxy.static_proxy.service.other.IOther;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/10/13 23:47
 */
public class OtherInterfaceProxy implements IOther {
    //被代理者的引用
    private IOther target;

    public OtherInterfaceProxy(IOther lawsuit) {
        before();
        target = lawsuit;
        after();
    }


    private void before() {     // 在执行方法之前执行
        System.out.println("阅读材料");
    }
    private void after() {      // 在执行方法之后执行
        System.out.println("记录问题");
    }

    @Override
    public void doSomething() {
        before();
        target.doSomething();
        after();
    }
}
