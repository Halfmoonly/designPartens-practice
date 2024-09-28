package org.lyflexi.responsibilityChainPattern.chainOfFactory;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 17:58
 */
public class ChainFactory {
    AbstractHandler firstHandler;
    public ChainFactory () {
        AbstractHandler accountHandler = new VerifyAccountHandler();
        AbstractHandler roleHanlder = new VerifyRoleHanlder();
        AbstractHandler permissionHanlder = new VerifyPermissionHanlder();
        accountHandler.setNextHandler(roleHanlder);
        roleHanlder.setNextHandler(permissionHanlder);
        firstHandler = accountHandler;
    }
    public boolean executeHandler (LoginUser loginUser) {
        return firstHandler.doHandler(loginUser);
    }


}
