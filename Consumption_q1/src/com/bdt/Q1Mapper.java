package com.bdt;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Q1Mapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("YEAR"), new Text("MIN\tMAX"));
	}
	
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("--------------"), new Text("..."));
	}
	
	//LW- we want full line so
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		String vals[]=line.split(",");
		String year=vals[0];				//first col value we are taking which is year
		int min=Integer.parseInt(vals[1]);
		int max=Integer.parseInt(vals[1]);
		
		for(int i=1; i<vals.length-1;i++)	//don't take first field and last field because first is year and last is avg
		{
			int consumption=Integer.parseInt(vals[i]);
			if(min>consumption)
			{
				min=consumption;
			}
			
			if(max<consumption)
			{
				max=consumption;
			}
			
		}
		context.write(new Text(year), new Text(min+"\t"+max));
		
	}
	
}
