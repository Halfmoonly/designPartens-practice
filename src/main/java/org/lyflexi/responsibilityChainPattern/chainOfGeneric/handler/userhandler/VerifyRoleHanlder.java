package org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.userhandler;

import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.model.LoginUser;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:33
 */

public class VerifyRoleHanlder extends AbstractHandler<LoginUser,Boolean> {
    @Override
    public Boolean doHandler(LoginUser targetData) {
        if(!"admin".equals(targetData.getRoleName())){
            System.out.println("LoginUser角色信息有误");
            return false;
        }
        System.out.println("2.LoginUser角色信息校验通过");

        return super.handle(targetData);
    }
}

