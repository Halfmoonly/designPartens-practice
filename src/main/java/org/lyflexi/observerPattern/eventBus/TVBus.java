package org.lyflexi.observerPattern.eventBus;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 
 **/
public class TVBus {

    private final Map<Class<? extends Event>, List<EventObListener>> listenerMap = new HashMap<>();

    /**
     * @description:订阅感兴趣的事件，事件类型由用户传入
     * @author: hmly 
     * @date: 2025/5/17 18:19
     * @param: [listener, eventClass]
     * @return: void
     **/
    public void subscribe(EventObListener listener, Class<? extends Event> eventClass) {
        listenerMap.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(listener);
    }

    public void publish(Event event) {
        Class<? extends Event> aClass = event.getClass();
        List<EventObListener> eventObListeners = listenerMap.get(aClass);
        if (eventObListeners != null) {
            eventObListeners.forEach(listener -> listener.onEvent(event));
        }
    }

}
