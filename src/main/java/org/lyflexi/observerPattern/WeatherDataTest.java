package org.lyflexi.observerPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:47
 */

public class WeatherDataTest {
    public static void main(String[] args) {
        //气象数据即被观察者
        WeatherData weatherData = new WeatherData();
        //天气展示即观察者，观察者在创建的时候会自动注册进weatherData中的观察者容器
        WeatherDisplay weatherDisplay1 = new WeatherDisplay(weatherData,"weatherDisplay1");
        WeatherDisplay weatherDisplay2 = new WeatherDisplay(weatherData,"weatherDisplay2");
        //被动通知
        weatherData.setMessurements(37.2f,80f,32.5f);
        //主动展示
        weatherDisplay1.display();
        weatherDisplay2.display();
    }
}

