package com.bdt;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
// A,a->part 0 file
//Z,z->part 25th file
//all other ->26th file
//no of reducer tasks to 27

public class AlphaPartitioner  extends Partitioner<Text, IntWritable>{
	@Override
	public int getPartition(Text key, IntWritable value, int numOfReducers) {
		char ch=key.toString().toLowerCase().charAt(0);
		if(ch>=97 && ch<=122) { 
			return ch-97;
		}
	
		else {
			return 26;
			}
		}
	
}
