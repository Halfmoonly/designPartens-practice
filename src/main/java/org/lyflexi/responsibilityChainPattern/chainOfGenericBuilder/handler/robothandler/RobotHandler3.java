package org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.robothandler;

import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGenericBuilder.model.Robot;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:33
 */

public class RobotHandler3 extends AbstractHandler<Robot,Boolean> {
    @Override
    public Boolean doHandler(Robot targetData) {
        if(!"admin".equals(targetData.getRoleName())){
            System.out.println("Robot角色信息有误");
            return false;
        }
        System.out.println("3.Robot角色信息校验通过");

        return super.handle(targetData);
    }
}

