package org.lyflexi.observerPattern.observer;

import java.util.function.Consumer;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class UserObListener implements ObListener {

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
    public void onListener(String info) {
        receiveInfo(info);
    }
}
