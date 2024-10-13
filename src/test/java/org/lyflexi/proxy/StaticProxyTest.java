package org.lyflexi.proxy;


import org.junit.Test;

import org.lyflexi.proxy.static_proxy.proxy.LawsuitInterfaceProxy;
import org.lyflexi.proxy.static_proxy.proxy.OtherInterfaceProxy;
import org.lyflexi.proxy.static_proxy.service.lawsuit.ILawsuit;
import org.lyflexi.proxy.static_proxy.service.lawsuit.impl.XiaoGangLawSuit;
import org.lyflexi.proxy.static_proxy.service.lawsuit.impl.XiaoHongLawSuit;
import org.lyflexi.proxy.static_proxy.service.other.IOther;
import org.lyflexi.proxy.static_proxy.service.other.impl.OtherImpl1;
import org.lyflexi.proxy.static_proxy.service.other.impl.OtherImpl2;

public class StaticProxyTest {

    @Test
    public void testILawsuitProxy() {
        // 构造一个小刚
        ILawsuit xiaogang = new XiaoGangLawSuit();
        // 构造一个代理律师将小刚作为构造参数传递进去
        ILawsuit lawyerForXiaoGang = new LawsuitInterfaceProxy(xiaogang);
        // 诉讼律师提交诉讼申请
        lawyerForXiaoGang.submit();
        // 律师进行举证
        lawyerForXiaoGang.burden();
        // 律师代替小刚进行辩护
        lawyerForXiaoGang.defend();
        // 完成诉讼
        lawyerForXiaoGang.finish();

        System.out.println("----------------------");

        // 构造一个小红
        ILawsuit xiaohong = new XiaoHongLawSuit();
        // 构造一个代理律师将小刚作为构造参数传递进去
        ILawsuit lawyerForXiaoHong = new LawsuitInterfaceProxy(xiaohong);
        // 诉讼律师提交诉讼申请
        lawyerForXiaoHong.submit();
        // 律师进行举证
        lawyerForXiaoHong.burden();
        // 律师代替小刚进行辩护
        lawyerForXiaoHong.defend();
        // 完成诉讼
        lawyerForXiaoHong.finish();

    }

    @Test
    public void testIOtherProxy() {
        IOther otherImpl1 = new OtherImpl1();
        IOther otherImpl1Proxy = new OtherInterfaceProxy(otherImpl1);
        otherImpl1Proxy.doSomething();
        System.out.println("----------------------");

        IOther otherImpl2 = new OtherImpl2();
        IOther otherImpl2Proxy = new OtherInterfaceProxy(otherImpl2);
        otherImpl2Proxy.doSomething();
    }
}
