package org.lyflexi.facadePattern.safety;

/**
 * @Description:
 * @Author: hmly
 * @project: designPartens-practice
 * @Date: 2025/2/13 12:51
 */
public class ClientProcessor {
    /**
     * 不安全的process
     * @param father
     */
    public void process(Father father){
        //向下转型属于强制类型转换，强制类型转换存在隐私泄露风险
        Son1 son = (Son1)father;
        son.sayHello();
        son.sayHello();
        son.saySecret();
    }
}
