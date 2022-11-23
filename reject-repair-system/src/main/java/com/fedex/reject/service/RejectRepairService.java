package com.fedex.reject.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fedex.common.util.CommonUtils;
import com.fedex.common.util.KafkaProducerCallBack;
import com.fedex.reject.SwakInfo;
import com.fedex.reject.model.SwakRepository;
import com.fedex.reject.repository.SwakInfoRepository;

@Service
public class RejectRepairService {

	@Value("${kafka_event_rating_topic}")
	protected String kafka_event_rating_topic;

	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	SwakInfoRepository swakInfoRepository;

	public void sendMessage(SwakInfo swakInfo) throws JsonProcessingException, UnsupportedEncodingException {

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafka_event_rating_topic,
				new String(CommonUtils.convertObjectToJson(swakInfo)));
		future.addCallback(new KafkaProducerCallBack(kafka_event_rating_topic,
				new String(CommonUtils.convertObjectToJson(swakInfo))));

	}

}
