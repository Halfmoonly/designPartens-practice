package org.lyflexi.facadePattern.safety;

/**
 * @Description:
 * @Author: hmly
 * @project: designPartens-practice
 * @Date: 2025/2/13 12:45
 */
public class SonFacade implements Father{
    private Son1 son;
    public SonFacade(Son1 son){
        this.son = son;
    }
    @Override
    public void sayHello() {
        son.sayHello();
    }

    @Override
    public void sayWorld() {
        son.sayWorld();
    }
}
