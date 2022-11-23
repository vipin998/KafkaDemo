package com.fedex.invoice.listner;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fedex.common.model.InvoiceDetails;
import com.fedex.common.util.CommonUtils;

@Service
public class InvoiceConsumer {

	static final Logger logger = LoggerFactory.getLogger(InvoiceConsumer.class);

	@KafkaListener(topics = "${kafka_event_invoice_topic}")

	public void listen(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {

		// logger.info(" rattingSystem COnsummer "+message);

		InvoiceDetails convertJsonObject = CommonUtils.convertJsonObject(message.getBytes(), InvoiceDetails.class);

		logger.info(" rattingSystem COnsummer  " + convertJsonObject.toString()); 

	}
}
