package com.endava.workshop.flink.streaming.transformation;


import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;

public class RichFunction extends RichMapFunction<Integer, Integer> {

    int parallelismNum;

    @Override
    public void open(Configuration configuration) {

        parallelismNum = getRuntimeContext().getExecutionConfig().getParallelism();

        // do some initialization
        // e.g. establish a connection to an external system

        // also we can get more context information with:
        // getRuntimeContext()
    }

    @Override
    public Integer map(Integer value) throws Exception {
        System.out.println("parallelism: " + parallelismNum);
        return value;
    }

    @Override
    public void close() {
        // do some cleanup, e.g close connections to external systems
    }
}
