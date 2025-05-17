package org.lyflexi.observerPattern.eventBus;


/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public interface Event {

    long timestamp();

    Object source();

}
