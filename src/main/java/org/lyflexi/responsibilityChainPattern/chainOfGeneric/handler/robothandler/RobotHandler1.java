package org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.robothandler;

import org.apache.commons.lang3.StringUtils;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.handler.AbstractHandler;
import org.lyflexi.responsibilityChainPattern.chainOfGeneric.model.Robot;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:32
 */


public class RobotHandler1 extends AbstractHandler<Robot,Boolean> {
    @Override
    public Boolean doHandler(Robot targetData) {
        if (StringUtils.isBlank(targetData.getRobotName())){
            System.out.println("Robot机器人名不能为空");
            return false;
        }
        if (StringUtils.isBlank(targetData.getRobotType())){
            System.out.println("Robot机器类型不能为空");
            return false;
        }
        System.out.println("1.Robot名称类型校验通过");
        return super.handle(targetData);
    }
}

