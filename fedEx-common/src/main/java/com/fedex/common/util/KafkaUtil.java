package com.fedex.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaUtil {

	static final Logger logger = LoggerFactory.getLogger(KafkaUtil.class);

	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;


	@SuppressWarnings("unchecked")
	public void sendMessageToKafkaTopicAsync(String message, String kafkaTopicName) {

		logger.info("Sending to downstream: topic: {} message: {}", kafkaTopicName, message);
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopicName, message);
		future.addCallback(new KafkaProducerCallBack(kafkaTopicName, message));

	}

	

}
