package com.fedex.rating.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import com.fedex.common.kafka.KafkaConfigCommon;

@EnableKafka
@Configuration
@Component
public class KafkaConfiguration extends KafkaConfigCommon {

	static final Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);

	@Value("${kafka_ratting_consumer_group}")
	protected String kafka_ratting_consumer_group;

	@Value("${kafka_client_concurrency_ratting}")
	protected int kafka_client_concurrency_ratting;

	@Value("${kafkaBrokersAddress}")
	protected String kafkaBrokersAddress;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(kafka_client_concurrency_ratting);
		return factory;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokersAddress);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, kafka_ratting_consumer_group);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, Integer.MAX_VALUE);
		return new DefaultKafkaConsumerFactory<>(config);
	}

}
