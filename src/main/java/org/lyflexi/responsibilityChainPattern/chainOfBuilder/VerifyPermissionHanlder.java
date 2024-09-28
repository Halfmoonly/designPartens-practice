package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:50
 */

public class VerifyPermissionHanlder extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return false;
        }
        System.out.println("3.权限校验通过，登录成功");

        return super.handle(loginUser);
    }
}

