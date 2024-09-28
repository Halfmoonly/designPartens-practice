package org.lyflexi.responsibilityChainPattern.chainOfFactory;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:51
 */

public class TestChain {
    public static void main(String[] args) {

        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
//        loginUser.setPassword("123");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");

        ChainFactory chainFactory = new ChainFactory();
        chainFactory.executeHandler(loginUser);
    }
}

