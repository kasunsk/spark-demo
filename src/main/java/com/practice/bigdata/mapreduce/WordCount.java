package com.practice.bigdata.mapreduce;



/**
 * Created by kasun on 7/13/19.
 */
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {

    public static void main(String [] args) throws IOException {
        WordCount wordCount = new WordCount();
        Configuration config = wordCount.config();
        Job job = wordCount.getJob(config);
        addInputOutputPath(args, config, job);
        try {
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addInputOutputPath(String[] args, Configuration config, Job job) throws IOException {
        String[] files=new GenericOptionsParser(config,args).getRemainingArgs();
        Path input = new Path(files[0]);
        Path output=new Path(files[1]);
        if (job == null) {
            System.out.println("Job is null");
        } else {
            FileInputFormat.addInputPath(job, input);
            FileOutputFormat.setOutputPath(job, output);
        }
    }

    public Configuration config() throws IOException {
        return new Configuration();
    }

    public Job getJob(Configuration configuration) {
        Job job = null;
        try {
            job = new Job(configuration, "wordcount");
            job.setJarByClass(WordCount.class);
            job.setMapperClass(MapForWordCount.class);
            job.setReducerClass(ReduceForWordCount.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return job;
    }
}
