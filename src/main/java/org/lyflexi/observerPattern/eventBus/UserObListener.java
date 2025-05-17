package org.lyflexi.observerPattern.eventBus;

import java.util.function.Consumer;

/**
 * @author 
 **/
public class UserObListener implements EventObListener {

    private final String name;

    private final Consumer<String> consumer;

    public UserObListener(String name, Consumer<String> consumer) {
        this.name = name;
        this.consumer = consumer;
    }


    public void receiveInfo(String info) {
        consumer.accept(info);
    }


    @Override
    public void onEvent(Event event) {
        if (event instanceof WeatherUpdateEvent) {
            receiveInfo(event.source().toString());
        }
    }
}
