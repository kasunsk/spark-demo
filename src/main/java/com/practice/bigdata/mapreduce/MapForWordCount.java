package com.practice.bigdata.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by kasun on 7/13/19.
 */
public class MapForWordCount  extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException {

        String line = value.toString();
        String[] words = line.split(",");
        for (String word : words) {
            Text outputKey = new Text(word.toUpperCase().trim());
            IntWritable outputValue = new IntWritable(1);
            con.write(outputKey, outputValue);
        }
    }
}
