package com.endava.workshop.flink.streaming;

import com.endava.workshop.flink.streaming.transformation.MapToKeyBy;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource;

public class FlinkExample2 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();

        /**
         * Read an Input Stream
         */
        DataStream<WikipediaEditEvent> edits = see.addSource(new WikipediaEditsSource());
        SingleOutputStreamOperator<Tuple2<Boolean, Integer>> result = edits.map(new MapToKeyBy()).keyBy(0).timeWindow(Time.seconds(5)).sum(1);

        result.print();

        /**
         * You already have mapped each line to (true,1) or (false,1), we need to aggregate it.
         * If you are from SQL background, keyBy(0) and sum(1): this is same as GROUP BY first item in tuple and SUM second item.
         */

        see.execute();


    }

}
