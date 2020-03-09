package com.endava.workshop.flink.streaming.transformation;

import com.endava.workshop.flink.streaming.model.TwitterEvent;
import org.apache.flink.api.common.functions.FilterFunction;

public class TwitterFilterFunction implements FilterFunction<TwitterEvent> {
    @Override
    public boolean filter(TwitterEvent twitterEvent) throws Exception {
       return false;
    }
}
