package com.practice.bigdata.spark;

import java.util.*;

import com.practice.bigdata.context.Context;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.*;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SampleConsumer {

    public static void main (String [] args) {

        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put("bootstrap.servers", "localhost:9092");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", StringDeserializer.class);
        kafkaParams.put("group.id", "use_a_separate_group_id_for_each_stream");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);

        Collection<String> topics = Arrays.asList("demo");

        JavaStreamingContext streamingContext = new Context("local[*]", "BigDataSample",
                new Duration(100));

//        final JavaInputDStream<ConsumerRecord<String, String>> stream =
//                KafkaUtils.createDirectStream(
//                        streamingContext,
//                        LocationStrategies.PreferConsistent(),
//                        ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
//                );
//
//        stream.mapToPair(
//                new PairFunction<ConsumerRecord<String, String>, String, String>() {
//                    @Override
//                    public Tuple2<String, String> call(ConsumerRecord<String, String> record) {
//                        return new Tuple2<>(record.key(), record.value());
//                    }
//                });
    }
}
