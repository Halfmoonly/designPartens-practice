package org.lyflexi.responsibilityChainPattern.chainOfBuilder;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 18:14
 */
public class ChainBuilder {
    private AbstractHandler head;
    private AbstractHandler tail;

    public ChainBuilder addHanlder(AbstractHandler handler){
        if (null == head){//head==null表示第一次添加到队列
            head = this.tail = handler;
            return this;
        }
        this.tail.setNextHandler(handler);//原tail节点指向新添加进来的节点
        this.tail = handler;//新添加进来的节点设置为tail节点
        return this;
    }

    public AbstractHandler build(){
        return this.head;
    }
}
