package com.practice.bigdata.context;

import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class Context extends JavaStreamingContext {

    public Context(String master, String appName, Duration batchDuration) {
        super(master, appName, batchDuration);
    }
}
