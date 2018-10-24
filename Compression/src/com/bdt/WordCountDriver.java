package com.bdt;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		conf.set("mapreduce.map.output.compress", "true"); //changed --map output
		
		Job job=Job.getInstance(conf, "WordCount"); //another way of defining object
		job.setJarByClass(WordCountDriver.class);  //main class file name
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileOutputFormat.setCompressOutput(job, true);  //changed  .deflate file will be generated as MR job output
		FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class); //changed --type of compression	
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		boolean status=job.waitForCompletion(true); 
		int result=status?0:1;
		System.exit(result);
		
	}
}
