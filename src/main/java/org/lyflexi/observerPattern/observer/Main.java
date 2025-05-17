package org.lyflexi.observerPattern.observer;


/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    //  观察者模式 --> 事件产生者WeatherStation产生消息，直接发送事件通知用户
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        UserObListener tom = new UserObListener("tom", (info) -> {
            if (info.equals("晴天")) {
                System.out.println("晴天啦,tom出去玩");
            } else {
                System.out.println("tom在家呆着");
            }
        });
        UserObListener jerry = new UserObListener("jerry", (info) -> {
            if (info.equals("雨天")) {
                System.out.println("雨天了，jerry 钻洞");
            }
        });
        station.subscribe(tom);
        station.subscribe(jerry);
        station.start();
    }
}


