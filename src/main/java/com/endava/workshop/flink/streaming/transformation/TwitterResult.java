package com.endava.workshop.flink.streaming.transformation;

import com.endava.workshop.flink.streaming.model.TwitterEvent;
import org.apache.flink.api.common.functions.RichMapFunction;

public class TwitterResult extends RichMapFunction<TwitterEvent, String> {
    @Override
    public String map(TwitterEvent twitterEvent) throws Exception {
        return null;
    }
}
