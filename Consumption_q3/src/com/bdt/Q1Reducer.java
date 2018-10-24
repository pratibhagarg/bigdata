package com.bdt;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Q1Reducer extends Reducer<IntWritable, Text, Text, Text>{
	
	
	IntWritable minConsumption=new IntWritable();
	IntWritable maxConsumption=new IntWritable();
	Text minyears=new Text();
	Text maxyears=new Text();
	int i=0;
	@Override
	protected void reduce(IntWritable key, Iterable<Text> values, Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		if(i==0) {
			i=i+1;
			minConsumption.set(key.get());
			String temp="";
			for(Text val: values)
			{
				temp=temp+","+val.toString();
			}
			minyears.set(temp);
		}
		else
		{
			//maxConsumption=key;
			maxConsumption.set(key.get());
			String temp="";
			for(Text val: values)
			{
				temp=temp+","+val.toString();
			}
			maxyears.set(temp);
		}

	}

	@Override
	protected void cleanup(Reducer<IntWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		context.write(new Text("Min consumption"), new Text(minConsumption+"\t"+minyears));
		context.write(new Text("Max consumption"), new Text(maxConsumption+"\t"+maxyears));
	}
	
}
