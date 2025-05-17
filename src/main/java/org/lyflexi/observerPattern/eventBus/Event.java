package org.lyflexi.observerPattern.eventBus;


/**
 * @author 
 **/
public interface Event {

    long timestamp();

    Object source();

}
