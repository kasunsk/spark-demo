package com.practice.bigdata.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.bigdata.kafka.dto.CustomObject;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by kasun on 10/28/18.
 */
public class CustomSerializer implements Serializer<CustomObject> {


    public void configure(Map<String, ?> map, boolean b) {

    }

    public byte[] serialize(String s, CustomObject data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
            System.out.println("Error in serializing object"+ data);
        }
        return retVal;
    }

    public void close() {

    }
}
