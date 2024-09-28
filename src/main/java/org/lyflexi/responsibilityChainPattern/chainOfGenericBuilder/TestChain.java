package org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder;


import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.robothandler.RobotHandler1;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.robothandler.RobotHandler2;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.robothandler.RobotHandler3;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.userhandler.VerifyAccountHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.userhandler.VerifyPermissionHanlder;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.userhandler.VerifyRoleHanlder;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.model.LoginUser;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.model.Robot;

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
        ChainBuilder<LoginUser,Boolean> chainLoginUserBuilder = new ChainBuilder();
        chainLoginUserBuilder.addHanlder(new VerifyAccountHandler())
                .addHanlder(new VerifyRoleHanlder())
                .addHanlder(new VerifyPermissionHanlder());
        chainLoginUserBuilder.build().doHandler(loginUser);




        Robot robot = new Robot();
        robot.setRobotName("机器人1号");
        robot.setRobotType("铁质机器人");
        robot.setRoleName("admin");
        robot.setPermission("admin");
        ChainBuilder<Robot,Boolean> chainRobotBuilder = new ChainBuilder();
        chainRobotBuilder.addHanlder(new RobotHandler1())
                .addHanlder(new RobotHandler2())
                .addHanlder(new RobotHandler3());
        chainRobotBuilder.build().doHandler(robot);

    }
}

