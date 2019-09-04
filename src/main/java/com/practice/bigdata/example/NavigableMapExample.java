package com.practice.bigdata.example;


import java.util.*;

/**
 * Created by kasun on 8/28/19.
 */
public class NavigableMapExample {

    public static void main(String [] args){

        NavigableMap<String, String> navigableMap1 = new TreeMap<>();
        navigableMap1.comparator();
        navigableMap1.put("test", "test");
        System.out.println(navigableMap1.get("test"));

        Map<byte[], byte[]> testMap = new HashMap<>();
        testMap.put("test".getBytes(), "test_val".getBytes());

        NavigableMap<byte [], byte []> navigableMap = new TreeMap<>(new NavigableComparator());
        navigableMap.comparator();
        navigableMap.put("test".getBytes(), "test1".getBytes());
        System.out.println(navigableMap.get("test".getBytes()));

    }

}
