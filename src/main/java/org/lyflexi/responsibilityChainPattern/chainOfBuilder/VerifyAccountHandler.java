package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:32
 */


public class VerifyAccountHandler extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if (StringUtils.isBlank(loginUser.getLoginName())){
            System.out.println("用户名不能为空");
            return false;
        }
        if (StringUtils.isBlank(loginUser.getPassword())){
            System.out.println("密码不能为空");
            return false;
        }
        if (!loginUser.getPassword().equals("123456")){
            System.out.println("密码不正确");
            return false;
        }
        System.out.println("1.账号密码校验通过");

        return super.handle(loginUser);
    }
}

