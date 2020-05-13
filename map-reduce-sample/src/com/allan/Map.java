package com.allan;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

    Logger logger = Logger.getLogger(Map.class.getSimpleName());

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        logger.log(Level.INFO, String.format("Key: %s - Value: %s", key.get(), value.toString()));

        String line = value.toString();
        String[] words = line.split(" ");

        for (String word: words) {
            context.write(new Text(word), new IntWritable());
        }

    }
}
