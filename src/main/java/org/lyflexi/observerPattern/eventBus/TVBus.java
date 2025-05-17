package org.lyflexi.observerPattern.eventBus;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class TVBus {

    private final Map<Class<? extends Event>, List<EventObListener>> listenerMap = new HashMap<>();

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
