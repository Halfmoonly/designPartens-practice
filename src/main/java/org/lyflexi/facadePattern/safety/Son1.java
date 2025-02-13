package org.lyflexi.facadePattern.safety;

/**
 * @Description:
 * @Author: hmly
 * @project: designPartens-practice
 * @Date: 2025/2/13 12:41
 */
public class Son1 implements Father{
    @Override
    public void sayHello(){
        System.out.println("hello ...");
    }
    @Override
    public void sayWorld(){
        System.out.println("world ...");
    }

    /**
     * 非接口方法
     */
    public void saySecret(){
        System.out.println("saySecret ...");
    }
}
