package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:31
 */

public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler handler){
        this.nextHandler = handler;
    }
    public boolean hasNext(){
        return nextHandler != null;
    }
    public boolean handle(LoginUser loginUser){
        if (hasNext()){
            nextHandler.doHandler(loginUser);
        }
        return true;
    }

    /**
     * 子类实现
     * @param loginUser
     * @return
     */
    public abstract boolean doHandler(LoginUser loginUser);

}
