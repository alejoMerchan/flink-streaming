package com.endava.workshop.flink.streaming;

import com.endava.workshop.flink.streaming.transformation.TwitterFilterFunction;
import com.endava.workshop.flink.streaming.transformation.TwitterResult;
import com.endava.workshop.flink.streaming.transformation.TwitterTranslate;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class FlinkExercise2 {

    public static void main(String[] args)throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:19092");
        properties.setProperty("zookeeper.connect", "localhost:12181");
        properties.setProperty("group.id", "test");

        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer<String>("my_topic", new SimpleStringSchema(), properties));

        // Translate the raw event to our domain event, String => TwitterEvent
        // Use the transform class TwitterRichFunction.

        // Filter the events with one or more hashTags
        // Use the filter class TwitterFilterFunction

        //Get only the author of the tweet
        // Use the transform class TwitterResult

        //stream.map().filter().map().print();
        env.execute();

    }
}
