package org.lyflexi.observerPattern.eventBus;


/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    //  普通观察者模式 --> 事件产生者WeatherStation产生消息，直接发送事件通知用户
    //      引发的问题：随着发布逻辑的日益复杂，引入了事件接口Event，要根据具体的事件类型通知不同的用户群体。这时直接给气象站加功能，会导致代码在气象站内耦合严重。
    //  基于事件驱动的观察者模式 -->  事件产生者WeatherStation产生消息 --> 交给总线TVBus电视台 --> 电视台通知用户监听器。
    //      - 多了一层总线接管部分气象站原有的代码，专门用来根据不同的事件类型做分发
    //      - 气象站只负责生产（外部接收）消息即可，然后转交给总线
    //      - 用户侧针对特定的事件类型做消费
    public static void main(String[] args) throws InterruptedException {
        TVBus tvBus = new TVBus();
        WeatherStation station = new WeatherStation(tvBus);
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
        tvBus.subscribe(tom, WeatherUpdateEvent.class);
        tvBus.subscribe(jerry, WeatherUpdateEvent.class);
        station.start();
    }
}


