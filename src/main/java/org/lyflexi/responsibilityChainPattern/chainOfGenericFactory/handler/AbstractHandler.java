package org.lyflexi.responsibilityChainPattern.chainOfGenericFactory.handler;


/**
 * @Author: ly
 * @Date: 2024/3/13 22:31
 */

public abstract class AbstractHandler<T,R> {
    protected AbstractHandler<T,R> nextHandler;

    public void setNextHandler(AbstractHandler<T,R> handler){
        this.nextHandler = handler;
    }
    public boolean hasNext(){
        return nextHandler != null;
    }

    public Boolean handle(T t){
        if (hasNext()){
            nextHandler.doHandler(t);
        }
        return true;
    }

    /**
     * 子类实现
     * @param
     * @return
     */
    public abstract R doHandler(T t);

}
