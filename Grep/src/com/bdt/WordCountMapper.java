package com.bdt;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//<> Generic syntax. Provide key, value data types(these are Hadoop data types)
public class WordCountMapper extends Mapper<LongWritable, Text, Text, NullWritable>{


@Override
protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
		throws IOException, InterruptedException {
	
	Configuration conf=context.getConfiguration(); //taken the configuration and added key 'sword' in that by generic parameters -Dsword=spark.
	String searchword=conf.get("sword");
	if(value.toString().toLowerCase().contains(searchword.toLowerCase()))
	{
		context.write(value, NullWritable.get());
	}
	
}
}