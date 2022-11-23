package com.fedex.reject.listner;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fedex.common.model.SwakInfo;
import com.fedex.common.util.CommonUtils;
import com.fedex.reject.SwakRepository;

@Service
public class ErrorListner  {

	@Autowired
	SwakRepository rejectRepairService;
	
	static final Logger logger = LoggerFactory.getLogger(ErrorListner.class);

	@KafkaListener(topics = "${kafka_event_error_topic}")

	public void listen(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {


		SwakInfo convertJsonObject = CommonUtils.convertJsonObject(message.getBytes(), SwakInfo.class);
		
		
		

		//rejectRepairService.save(convertJsonObject);
		
		logger.info(" kafka_event_error_topic   Consummer  " + convertJsonObject.toString());

	}
}
