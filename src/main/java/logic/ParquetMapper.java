package logic;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.log4j.Logger;

import dataTO.UserModCommand;

public  class ParquetMapper extends Mapper<NullWritable, UserModCommand, NullWritable, Text> {
	public Logger logger = Logger.getLogger(Main.class);
	private final static IntWritable one = new IntWritable(1); 
	
    public void map(NullWritable key, UserModCommand value, Context context) throws IOException, InterruptedException {
    	OperationHandler handler = new OperationHandler();
    	handler.performOperationByType(value);
    	//NullWritable nw = NullWritable.get();
    	//context.write(nw, new Text(UserRepository.getInstance().print()));
    }
 }