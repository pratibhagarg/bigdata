package com.bdt;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		//conf.set("mapreduce.job.reduces","1");
		
		
		//read all default XMLs 
		//set and get method
		//Job object- represents Map Reduce program. It talks to resource manager.
		Job job=Job.getInstance(conf, "WordCount"); //another way of defining object
		job.setJarByClass(WordCountDriver.class);  //main class file name
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		job.setNumReduceTasks(27);
		
		//job.setCombinerClass(WordCountReducer.class);
				
		//job.setPartitionerClass(AlphaPartitioner.class);
		job.setPartitionerClass(AlphaPartitioner.class);
		
		
		//when job input type and job output types are different
		//we need to mention job output key value types
		//LW T -> T LW
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//for this job where to get input and output
		//args[0], args[1]
		FileInputFormat.addInputPath(job, new Path(args[0]));
		//path object converts string into URI-> hdfs://localhost:9000/test.txt
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		boolean status=job.waitForCompletion(true); //keep asking status of job to Resource Manager --to start program execution
		//status will be true or false
		int result=status?0:1;
		System.exit(result);
		
	}
}
