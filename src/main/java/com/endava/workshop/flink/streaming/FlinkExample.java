package com.endava.workshop.flink.streaming;

import com.endava.workshop.flink.streaming.transformation.IncrementMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkExample {

    public static void main(String[] args) throws Exception{

        /**
         * Set up the Execution Environment
         */
        // Create a local stream execution environment
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();

        /**
         * Read an Input Stream
         */
        DataStreamSource<Integer> source = see.fromElements(1, 2, 3, 4, 5);

        /**
         * Apply Transformations
         */
        SingleOutputStreamOperator<Integer> outputStream = source.map(new IncrementMapFunction());

        /**
         * Output the result
         */
        outputStream.print();


    }
}
