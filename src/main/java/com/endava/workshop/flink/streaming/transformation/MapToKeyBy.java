package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;

public class MapToKeyBy implements MapFunction<WikipediaEditEvent, Tuple2<Boolean, Integer>> {

    @Override
    public Tuple2<Boolean, Integer> map(WikipediaEditEvent wikipediaEditEvent) throws Exception {
        Boolean isBotEdit = wikipediaEditEvent.isBotEdit();
        return new Tuple2<>(isBotEdit, 1);
    }
}
