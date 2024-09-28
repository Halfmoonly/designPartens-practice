package org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.userhandler;

import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.model.LoginUser;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:50
 */

public class VerifyPermissionHanlder extends AbstractHandler<LoginUser,Boolean> {
    @Override
    public Boolean doHandler(LoginUser targetData) {
        if (!"admin".equals(targetData.getPermission())){
            System.out.println("LoginUser暂无权限");
            return false;
        }
        System.out.println("3.LoginUser权限校验通过");
        return super.handle(targetData);
    }
}

