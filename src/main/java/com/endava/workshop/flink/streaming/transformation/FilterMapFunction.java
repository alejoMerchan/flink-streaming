package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.api.common.functions.FilterFunction;

public class FilterMapFunction implements FilterFunction<String> {


    @Override
    public boolean filter(String value) throws Exception {
        if (value.startsWith("A"))
            return true;
        else
            return false;
    }
}
