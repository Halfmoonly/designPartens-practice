package org.lyflexi.responsibilityChainPattern.chainOfGenericFactory;

import org.lyflexi.responsibilityChainPattern.chainOfGenericFactory.model.LoginUser;
import org.lyflexi.responsibilityChainPattern.chainOfGenericFactory.model.Robot;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:51
 */

public class TestChain {
    public static void main(String[] args) {

        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        ChainFactory loginUserChainFactory = new LoginUserChainFactory();
        loginUserChainFactory.assembleHandler(loginUser);
        loginUserChainFactory.executeHandler();



        Robot robot = new Robot();
        robot.setRobotName("机器人1号");
        robot.setRobotType("铁质机器人");
        robot.setRoleName("admin");
        robot.setPermission("admin");
        ChainFactory robotChainFactory = new RobotChainFactory();
        robotChainFactory.assembleHandler(robot);
        robotChainFactory.executeHandler();


    }
}

