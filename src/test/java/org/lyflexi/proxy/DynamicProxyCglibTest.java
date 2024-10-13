package org.lyflexi.proxy;


import net.sf.cglib.proxy.MethodInterceptor;

import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_cglib.dao.TestCglibService;
import org.lyflexi.proxy.dynamic_proxy_cglib.proxy.DaoMethodInterceptor;
import org.lyflexi.proxy.dynamic_proxy_cglib.proxy.DaoProxyFactory;


public class DynamicProxyCglibTest {

    @Test
    public void cglibTest() {
        MethodInterceptor interceptor = new DaoMethodInterceptor();

        TestCglibService service = DaoProxyFactory.newInstance(TestCglibService.class, interceptor);
        int cglibResult = service.testGet(1);
        System.out.println("cglib强行修改方法的返回值"+cglibResult);
    }
}
