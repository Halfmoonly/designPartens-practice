package org.lyflexi.observerPattern.eventBus;

/**
 * @author 
 **/
public abstract class BaseEvent implements Event {

    private final long timestamp;

    protected BaseEvent() {
        timestamp = System.currentTimeMillis();
    }

    @Override
    public long timestamp() {
        return timestamp;
    }
}
