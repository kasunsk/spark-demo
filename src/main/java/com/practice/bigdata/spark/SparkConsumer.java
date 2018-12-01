package com.practice.bigdata.spark;


import kafka.serializer.StringDecoder;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka.KafkaUtils;

import java.util.*;

/**
 * Created by kasun on 11/4/18.
 */
public class SparkConsumer {

    public static void main (String [] args) {
        SparkConsumer consumer = new SparkConsumer();
        try {
            consumer.consume("demo","localhost:9092" , "big-data-demo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume(String topic, String broker,  String appName) throws InterruptedException {
        JavaStreamingContext ssc = new JavaStreamingContext("local[*]", appName, new Duration(2000));

        Set<String> topics = new HashSet<>();
        topics.add(topic);
        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("metadata.broker.list", broker);

        JavaPairInputDStream<String, String> directKafkaStream = KafkaUtils.createDirectStream(ssc,
                String.class, String.class, StringDecoder.class, StringDecoder.class, kafkaParams, topics);

        directKafkaStream.foreachRDD(rdd -> {
            System.out.println("--- New RDD with " + rdd.partitions().size()
                    + " partitions and " + rdd.count() + " records");
//            rdd.foreach(record -> System.out.println(record._2));
        });

        ssc.start();
        ssc.awaitTermination();
    }


}
