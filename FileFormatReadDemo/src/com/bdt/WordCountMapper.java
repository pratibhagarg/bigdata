package com.bdt;
//sequence file read program
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Text, IntWritable, Text, IntWritable>
{
	@Override
	protected void map(Text key, IntWritable value, Mapper<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		context.write(new Text(value.toString()+"_1111"), value); //changed
	}
}