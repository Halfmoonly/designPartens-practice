package org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.robothandler;

import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.model.Robot;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:50
 */

public class RobotHandler2 extends AbstractHandler<Robot,Boolean> {
    @Override
    public Boolean doHandler(Robot targetData) {
        if (!"admin".equals(targetData.getPermission())){
            System.out.println("Robot暂无权限");
            return false;
        }
        System.out.println("2.Robot权限校验通过");
        return super.handle(targetData);
    }
}

