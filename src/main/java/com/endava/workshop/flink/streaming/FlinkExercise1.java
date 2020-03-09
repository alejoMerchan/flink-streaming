package com.endava.workshop.flink.streaming;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource;

public class FlinkExercise1 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();

        /**
         * Read an Input Stream
         */
        DataStream<WikipediaEditEvent> edits = see.addSource(new WikipediaEditsSource());

        // TODO, get the title of wikipedia events and filter by size > 10 characters
        // you need to use MapWikipediaEvent and FilterWikipediaEvent

        see.execute();

    }
}
