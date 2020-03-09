package com.endava.workshop.flink.streaming.transformation;

import org.apache.flink.runtime.testutils.MiniClusterResourceConfiguration;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.test.util.MiniClusterWithClientResource;
import org.junit.ClassRule;
import org.junit.Test;

public class ExampleFilterTest {


    @ClassRule
    public static MiniClusterWithClientResource flinkCluster =
            new MiniClusterWithClientResource(
                    new MiniClusterResourceConfiguration.Builder()
                            .setNumberSlotsPerTaskManager(2)
                            .setNumberTaskManagers(1)
                            .build());


    @Test
    public void testFilterExample() throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // configure your test environment
        env.setParallelism(2);

        // create a stream of customs elements and apply transformations (Map)
        env.fromElements("Alejandro","Luisa","Juan","Lina", "Andres","Andrea").filter(new FilterMapFunction()).print();

        // execute
        env.execute();
    }

}
