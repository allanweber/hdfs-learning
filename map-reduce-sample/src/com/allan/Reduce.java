package com.allan;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reduce extends Reducer<Text, IntWritable, Text, LongWritable> {

    Logger logger = Logger.getLogger(Reduce.class.getSimpleName());

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        logger.log(Level.INFO, String.format("Key: %s - Values: %s", key.toString(), values));

        long count = 0;

        for(IntWritable value: values) {
            count++;
        }

        context.write(key, new LongWritable(count));
    }
}
