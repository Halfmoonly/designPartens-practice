package org.lyflexi.responsibilityChainPattern.chainOfGeneric;


import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.robothandler.RobotHandler1;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.robothandler.RobotHandler2;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.robothandler.RobotHandler3;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.userhandler.VerifyAccountHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.userhandler.VerifyPermissionHanlder;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.userhandler.VerifyRoleHanlder;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.model.LoginUser;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.model.Robot;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 17:58
 */
public class RobotChainFactory extends ChainFactory<Robot,Boolean> {
    public RobotChainFactory() {

    }

    @Override
    public Boolean assembleHandler(Robot robot) {
        RobotHandler1 robotHandler1 = new RobotHandler1();
        RobotHandler2 robotHandler2 = new RobotHandler2();
        RobotHandler3 robotHandler3 = new RobotHandler3();
        robotHandler1.setNextHandler(robotHandler2);
        robotHandler2.setNextHandler(robotHandler3);
        super.firstHandler = robotHandler1;
        super.t = robot;
        return true;
    }


}
