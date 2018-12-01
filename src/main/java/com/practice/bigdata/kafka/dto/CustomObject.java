package com.practice.bigdata.kafka.dto;

/**
 * Created by kasun on 10/28/18.
 */
public class CustomObject {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "CustomObject { " +
                "name ='" + name + '\'' +
                '}';
    }
}
