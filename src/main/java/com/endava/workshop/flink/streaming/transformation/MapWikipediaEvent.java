package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;

public class MapWikipediaEvent implements MapFunction<WikipediaEditEvent,String> {

    @Override
    public String map(WikipediaEditEvent wikipediaEditEvent) throws Exception {

        //TODO: Get the title of wikipedia events and return it

        return null;
    }
}
