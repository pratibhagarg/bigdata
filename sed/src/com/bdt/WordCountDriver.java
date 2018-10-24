package com.bdt;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool{
	
	@Override
	public int run(String[] args) throws Exception {
		Configuration conf=this.getConf();//changed
		Job job=Job.getInstance(conf); //Changed removed program name
		job.setJarByClass(WordCountDriver.class);  //main class file name
		job.setMapperClass(WordCountMapper.class);
		
		//job.setReducerClass(WordCountReducer.class);
		//job.setNumReduceTasks(27);
		//job.setPartitionerClass(AlphaPartitioner.class);
		//when job input type and job output types are different
		//we need to mention job output key value types
		//LW T -> T LW
		//job.setOutputKeyClass(Text.class);
		//job.setOutputValueClass(IntWritable.class);
		
		//for this job where to get input and output
		//args[0], args[1]
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		return job.waitForCompletion(true)?0:1; //chnaged
	}
	

	public static void main(String[] args) throws Exception {
		
		
		 //keep asking status of job to Resource Manager --to start program execution
		//status will be true or false
		int status=ToolRunner.run(new WordCountDriver(), args);
		System.exit(status);
		
	}
}
