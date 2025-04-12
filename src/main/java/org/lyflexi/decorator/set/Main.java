package org.lyflexi.decorator.set;

import java.util.*;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    public static void main(String[] args) {
        //装饰器模式
        Set<String> historySet = new HistorySet<>(new HashSet<>());
        //嵌套的装饰器模式
        Set<String> set = new HistorySet<>(historySet);
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.remove("4");
        set.remove("4");
        set.remove("5");
        set.remove("1");
        System.out.println(set);
    }
}
