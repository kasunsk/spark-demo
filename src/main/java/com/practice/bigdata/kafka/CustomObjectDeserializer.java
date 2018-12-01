package com.practice.bigdata.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.bigdata.kafka.dto.CustomObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * Created by kasun on 10/28/18.
 */
public class CustomObjectDeserializer implements Deserializer<CustomObject> {

    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    public CustomObject deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        CustomObject object = null;
        try {
            object = mapper.readValue(data, CustomObject.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializing bytes "+ exception);
        }
        return object;
    }

    public void close() {
    }
}
