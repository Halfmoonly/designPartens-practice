package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:33
 */

public class VerifyRoleHanlder extends AbstractHandler {
    @Override
    public boolean doHandler(LoginUser loginUser) {
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return false;
        }
        System.out.println("2.角色信息校验通过");

        return super.handle(loginUser);
    }
}

