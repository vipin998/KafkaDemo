package com.fedex.rating.listner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fedex.common.model.InvoiceDetails;
import com.fedex.common.model.SwakInfo;
import com.fedex.common.util.CommonUtils;
import com.fedex.common.util.KafkaProducerCallBack;

@Service
public class KafkaConsumer {

	@Value("${kafka_event_invoice_topic}")
	protected String kafka_event_invoice_topic;

	@Value("${kafka_event_error_topic}")
	protected String kafka_event_error_topic;

	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;

	static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "${kafka_event_rating_topic}")

	public void listen(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {

		SwakInfo swakInfo = CommonUtils.convertJsonObject(message.getBytes(), SwakInfo.class);

		InvoiceDetails invoiceDetails = new InvoiceDetails();
		invoiceDetails.setAddress(swakInfo.getAddress());
		invoiceDetails.setEmail(swakInfo.getEmail());
		invoiceDetails.setBillTo(swakInfo.getBillTo());
		invoiceDetails.setDiscount(swakInfo.getDiscount());
		invoiceDetails.setInvoice(swakInfo.getContainerNumber());
		invoiceDetails.setItemDescription(swakInfo.getItemDescription());
		invoiceDetails.setEmail(swakInfo.getEmail());

		boolean validate = validate(swakInfo);
		
		


		if (validate) {

			
			sendMessegae(invoiceDetails, kafka_event_invoice_topic);
			logger.info(" sending to invoiceDetails topic  " + swakInfo.toString());
		}else {
			
			sendMessegae(swakInfo, kafka_event_error_topic);
			logger.info("sending to error topic  " + swakInfo.toString() );
		}

	}

	private boolean validate(SwakInfo swakInfo) {

		String email = swakInfo.getEmail();

		if (email.contains("@")) {

			return true;
		}
		return false;

	}

	void sendMessegae(Object objInfo, String topicDetails)
			throws JsonProcessingException, UnsupportedEncodingException {

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicDetails,
				new String(CommonUtils.convertObjectToJson(objInfo)));
		future.addCallback(
				new KafkaProducerCallBack(topicDetails, new String(CommonUtils.convertObjectToJson(objInfo))));

	}
}
