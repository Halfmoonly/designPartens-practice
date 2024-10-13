package org.lyflexi.proxy.static_proxy.proxy;

import org.lyflexi.proxy.static_proxy.service.lawsuit.ILawsuit;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/10/13 23:47
 */
public class LawsuitInterfaceProxy implements ILawsuit {
    //被代理者的引用
    private ILawsuit target;

    public LawsuitInterfaceProxy(ILawsuit lawsuit) {
        before();
        target = lawsuit;
        after();
    }

    @Override
    public void submit() {
        before();
        target.submit();
        after();
    }

    @Override
    public void burden() {
        before();
        target.burden();
        after();
    }

    @Override
    public void defend() {
        before();
        target.defend();
        after();
    }

    @Override
    public void finish() {
        before();
        target.finish();
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.println("阅读材料");
    }
    private void after() {      // 在执行方法之后执行
        System.out.println("记录问题");
    }
}
