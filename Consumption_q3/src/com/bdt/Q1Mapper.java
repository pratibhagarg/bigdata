package com.bdt;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, IntWritable, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Text>.Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		String vals[]=line.split(",");
		String year=vals[0];				//first value we are taking which is year
		
		
		for(int i=1; i<vals.length-1; i++)	//don't take first field and last field because first is year and last is avg
		{
			int consumption=Integer.parseInt(vals[i]);
			context.write(new IntWritable(consumption), new Text(year));
		}
		//temp and year as tuple
		//<year,year>
	}
	
}
