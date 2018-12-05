package com.practice.bigdata.spark;

import org.apache.spark.sql.SparkSession;

/**
 * Created by kasun on 12/1/18.
 */
public class TopicProvider {

    SparkSession sparkSession;

    public TopicProvider(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void publish(String topicName, byte [] data) {


    }
}
