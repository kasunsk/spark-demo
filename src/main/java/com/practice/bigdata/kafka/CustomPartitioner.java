package com.practice.bigdata.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * Created by kasun on 10/28/18.
 */
public class CustomPartitioner implements Partitioner {

    private static final int PARTITION_COUNT=50;

    public void configure(Map<String, ?> configs) {
    }

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Integer keyInt=Integer.parseInt(key.toString());
        return keyInt % PARTITION_COUNT;
    }

    public void close() {
    }
}
