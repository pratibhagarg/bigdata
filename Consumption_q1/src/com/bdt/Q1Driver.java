package com.bdt;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Q1Driver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	

	Configuration conf= new Configuration();
	Job job=Job.getInstance(conf,"Q1 Driver");
	job.setJarByClass(Q1Driver.class);
	job.setMapperClass(Q1Mapper.class);
	job.setNumReduceTasks(0);
	
	FileInputFormat.addInputPath(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));
	System.exit(job.waitForCompletion(true)?0:1);
	
	}
	
}
