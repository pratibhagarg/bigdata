package com.bdt;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf, "WordCount"); //another way of defining object
		job.setJarByClass(WordCountDriver.class);  //main class file name
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
	
		job.setNumReduceTasks(0); //changed
		//job.setOutputKeyClass(Text.class);
		//job.setOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(SequenceFileAsTextInputFormat.class);//changed
		
		//job.setOutputFormatClass(SequenceFileOutputFormat.class); //changed
		//SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.RECORD); //changed
		//SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK); //changed	
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		boolean status=job.waitForCompletion(true);
		int result=status?0:1;
		System.exit(result);
		
	}
}
