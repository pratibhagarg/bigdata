package com.bdt;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//<> Generic syntax. Provide key, value data types(these are Hadoop data types)
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

//	Text text1=new Text();
//	IntWritable ONE=new IntWritable(1);
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		//ctrl+d to remove extra lines
		String line= value.toString(); //convert hadoop types to java types because in hadoop types we dnt hv split method
		StringTokenizer words= new StringTokenizer(line, " ");
		
		while(words.hasMoreTokens())
		{
			String word=words.nextToken();
			context.write(new Text(word), new IntWritable(1));
			//text1.set(word);
			//context.write(text1, ONE);
		}
		//Divide line into words,take one word and send word, 1
		//hi welcome to hadoop welcome
		//hi , 1 welcome,1 to,1 hadoop,1 welcome 1
	}
	
	
	
}
