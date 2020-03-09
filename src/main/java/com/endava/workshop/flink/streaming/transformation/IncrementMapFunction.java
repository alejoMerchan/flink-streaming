package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.api.common.functions.MapFunction;

public class IncrementMapFunction implements MapFunction<Integer, Integer> {

    @Override
    public Integer map(Integer record) throws Exception {
        return record + 1;
    }
}
