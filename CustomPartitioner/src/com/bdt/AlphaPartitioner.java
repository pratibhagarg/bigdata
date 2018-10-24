package com.bdt;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


//job.setCombinerClass(WordOCuntReducer.class);
//job.setNumRedcudeTasks(3);
//job.setPartitionerClass(alphaParttioner.class);



public class AlphaPartitioner  extends Partitioner<Text, IntWritable>{
	@Override
	public int getPartition(Text key, IntWritable value, int numOfReducers) {
		char ch=key.toString().toLowerCase().charAt(0);
		if(ch>=97 && ch<=109) { //A or a to M or m
			return 0;
		}
		else if(ch>109 && ch<=122) { //M or m to Z or z
			return 1;
		}
		else return 2;
	}
}
