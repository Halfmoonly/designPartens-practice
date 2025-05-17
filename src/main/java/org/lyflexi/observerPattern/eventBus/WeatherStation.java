package org.lyflexi.observerPattern.eventBus;

import java.util.Random;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class WeatherStation {


    private final TVBus station;

    public WeatherStation(TVBus station) {
        this.station = station;
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
            station.publish(new WeatherUpdateEvent(info));
            Thread.sleep(3000);
        }
    }
}
