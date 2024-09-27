package org.lyflexi.observerPattern;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:46
 */
@Data
@Slf4j
public class WeatherDisplay implements Observer {
    private String weatherDisplayName;
    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    public WeatherDisplay(Subject subject,String weatherDisplayName) {//注册监听对象
        subject.registerObserver(this);
        this.weatherDisplayName = weatherDisplayName;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        log.info("被动通知：当前观察者为：{},触发更新温度为：{},湿度为：{},气压为：{}",this.weatherDisplayName,temperature,humidity, pressure);
    }

    public void display(){
        log.info("主动展示：当前观察者为：{},更新后的温度为：{},湿度为：{},气压为：{}",this.weatherDisplayName,temperature,humidity, pressure);
    }


}

