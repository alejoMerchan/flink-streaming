package com.endava.workshop.flink.streaming.transformation;

import com.endava.workshop.flink.streaming.model.TwitterEvent;
import org.apache.flink.api.common.functions.RichMapFunction;
import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwitterTranslate extends RichMapFunction<String, TwitterEvent> {


    @Override
    public TwitterEvent map(String s) throws Exception {

        Status status = TwitterObjectFactory.createStatus(s);
        //status.getUser().getName();
        //status.getCreatedAt();
        //System.currentTimeMillis();
        //getHashTags(status.getHashtagEntities());

        TwitterEvent event = new TwitterEvent();

        return event;
    }


    private List<String> getHashTags(HashtagEntity[] hashTagEntities) {
        List<String> hasTags = Arrays.stream(hashTagEntities).map(x -> x.getText()).collect(Collectors.toList());
        return hasTags;
    }
}
