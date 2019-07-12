package com.practice.bigdata.spark;


import kafka.serializer.StringDecoder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka.KafkaUtils;

import java.util.*;

/**
 * Created by kasun on 11/4/18.
 */
public class SparkConsumer {

    SparkSession sparkSession;

    public SparkConsumer(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public static void main(String[] args) {

        SparkSession sparkSession = SparkSession.builder()
                .master("local")
                .appName("Word Count")
//                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        SparkConsumer consumer = new SparkConsumer(sparkSession);
        consumer.consumerTopic("provide", "localhost:9092");
    }

    public void consumerTopic(String topic, String broker) {

        Dataset<Row> df = sparkSession.readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", broker)
                .option("subscribe", topic)
                .option("startingOffsets", "earliest")
                .load();

        System.out.println("printing schema ......");
        df.printSchema();
        df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)");

        System.out.println("writing to console ......");
        df.writeStream().format("console").start();

    }

    public void consume(String topic, String broker, String appName) throws InterruptedException {
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
