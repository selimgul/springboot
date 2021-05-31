package com.gul.selim;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.ConsumerStrategy;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.springframework.core.env.ConfigurableEnvironment;

public class SparkKafkaEngine {

	private ConfigurableEnvironment env;
	
	public SparkKafkaEngine(ConfigurableEnvironment env) {
		this.env = env;
	}
	
	public void start() throws InterruptedException {
		JavaStreamingContext javaStreamContext = createStreamingContext();
		JavaInputDStream<ConsumerRecord<String, String>> kafkaMessageStream = createKafkaStream(javaStreamContext);
		consumeKafkaMessages(kafkaMessageStream);
		startStreamingContext(javaStreamContext);	
	}
	
	private JavaStreamingContext createStreamingContext() {
		String sparkAppName = env.getProperty("spark.app.name");
		long sparkDuration = Long.parseLong(env.getProperty("spark.duration"));
		
		SparkConf sparkConf = new SparkConf().setAppName(sparkAppName).set("spark.master", "local");
		JavaStreamingContext jsContext = new JavaStreamingContext(sparkConf, Durations.seconds(sparkDuration));
		
		return jsContext;		
	}
	private JavaInputDStream<ConsumerRecord<String, String>> createKafkaStream(JavaStreamingContext jsContext) {
		
		return KafkaUtils.createDirectStream(jsContext,
				LocationStrategies.PreferConsistent(),
				createConsumerStrategy());
	}
	private ConsumerStrategy<String, String> createConsumerStrategy()
	{
		String kafkaBootstrapServers = env.getProperty("kafka.bootstrap.servers");
		String kafkaGroupID =env.getProperty("kafka.group.id");
		String kafkaTopicName = env.getProperty("kafka.topic.name");

		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put("bootstrap.servers",  kafkaBootstrapServers);
		kafkaParams.put("key.deserializer",   StringDeserializer.class);
		kafkaParams.put("value.deserializer", StringDeserializer.class);
		kafkaParams.put("group.id",           kafkaGroupID);
		kafkaParams.put("auto.offset.reset", "latest");
		kafkaParams.put("enable.auto.commit", true);
		
		Collection<String> topics = Arrays.asList(kafkaTopicName);
		
		return ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams);				
	}
	private void consumeKafkaMessages(JavaInputDStream<ConsumerRecord<String, String>> messageStream)
	{
		messageStream.foreachRDD(rdd -> {
			rdd.foreach(msg -> {				
				System.out.println("============================================================");
				System.out.println("Received Kafka Message: " + msg.value());
				System.out.println("============================================================");
			});
		});

	}
	private void startStreamingContext(JavaStreamingContext jsContext) throws InterruptedException {
		jsContext.start();
		jsContext.awaitTermination();
	}

}
