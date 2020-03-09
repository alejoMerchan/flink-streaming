package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.api.common.functions.FilterFunction;

public class FilterWikipediaEvent implements FilterFunction<String> {

    @Override
    public boolean filter(String s) throws Exception {

        //TODO: validate if the title has more of 10 characters.

        return false;
    }
}
