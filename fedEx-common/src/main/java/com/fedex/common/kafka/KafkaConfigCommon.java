package com.fedex.common.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @author vipin barman
 *
 */
@Configuration
public class KafkaConfigCommon {

	@Value("${kafka_api_key}")
	protected String api_key;

	@Value("${kafka_user}")
	protected String user;

	@Value("${kafka_password}")
	protected String password;


	@Value("${kafka_producer_batch_size}")
	protected int kafka_producer_batch_size;

	@Value("${kafka_producer_linger_ms}")
	protected int kafka_producer_linger_ms;

	@Value("${kafka_producer_request_timeout_ms}")
	protected int kafka_producer_request_timeout_ms;

	@Value("${kafka_producer_buffer_memory_bytes}")
	protected int producerBufferMemoryBytes;

	@Value(value = "${kafkaBrokersAddress}")
	protected String bootstrapAddress;

	@Value(value = "${kafka_event_rating_topic}")
	protected String kafka_event_rating_topic;

	@Value(value = "${kafka_rating_partition_count}")
	protected int kafka_rating_partition_count;

	@Value(value = "${kafka_event_invoice_topic}")
	protected String kafka_event_invoice_topic;

	@Value(value = "${kafka_rating_partition_count}")
	protected int kafka_invoice_partition_count;
	
	@Value(value = "${kafka_event_error_topic}")
	protected String kafka_event_error_topic;

	@Value(value = "${kafka_error_partition_count}")
	protected int kafka_error_partition_count;
	

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();

		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094");

		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, kafka_producer_batch_size);

		configProps.put(ProducerConfig.LINGER_MS_CONFIG, kafka_producer_linger_ms);

		configProps.put(ProducerConfig.ACKS_CONFIG, "all");

		configProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 5);

		configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

		// request timeout 5 mins : to handle any network issues

		configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, kafka_producer_request_timeout_ms);

		// 128 mb

		configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, producerBufferMemoryBytes);

		// for org.apache.kafka.common.errors.NotLeaderForPartitionException

		configProps.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);

		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopic topic1() {
		return new NewTopic(kafka_event_rating_topic, kafka_rating_partition_count, (short) 1);
	}

	@Bean
	public NewTopic topic2() {
		return new NewTopic(kafka_event_invoice_topic, kafka_invoice_partition_count, (short) 1);
	}
	
	@Bean
	public NewTopic topic3() {
		return new NewTopic(kafka_event_error_topic, kafka_error_partition_count, (short) 3);
	}

}
