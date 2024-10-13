package org.lyflexi.proxy.static_proxy.service.lawsuit.impl;

import org.lyflexi.proxy.static_proxy.service.lawsuit.ILawsuit;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/10/13 23:45
 */
public class XiaoHongLawSuit implements ILawsuit {
    @Override
    public void submit() {
        //老板拖欠小红工资 小红只好申请仲裁
        System.out.println("小红的情况：老板拖欠工资！特此申请仲裁！");
    }

    @Override
    public void burden() {
        System.out.println("小红的情况：这是合同书和过去一年的银行工资流水！");
    }

    @Override
    public void defend() {
        System.out.println("小红的情况：证据确凿，无需多言！");
    }

    @Override
    public void finish() {
        System.out.println("小红的情况：诉讼成功，老板即日起7天内结算工资");
    }
}
