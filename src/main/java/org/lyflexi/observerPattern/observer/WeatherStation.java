package org.lyflexi.observerPattern.observer;

import org.lyflexi.observerPattern.eventBus.Event;

import java.util.*;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class WeatherStation {

    private final List<UserObListener>  observers = new ArrayList<>();

    public void subscribe(UserObListener observer) {
        observers.add(observer);
    }

    public void publish(String info) {
        observers.forEach(observer -> observer.onListener(info));
    }

    public String getInfo() {
        if (new Random().nextBoolean()) {
            return "晴天";
        }
        return "雨天";
    }

    public void start() throws InterruptedException {
        while (true) {
            String info = getInfo();
            publish(info);
            Thread.sleep(3000);
        }
    }
}
