package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:54
 */

public class TestBuildChain {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        ChainBuilder chainBuilder = new ChainBuilder();
        chainBuilder.addHanlder(new VerifyAccountHandler())
                .addHanlder(new VerifyRoleHanlder())
                .addHanlder(new VerifyPermissionHanlder());
        chainBuilder.build().doHandler(loginUser);
    }
}
