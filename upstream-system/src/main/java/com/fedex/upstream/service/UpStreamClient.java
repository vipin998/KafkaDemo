
package com.fedex.upstream.service;

import java.io.UnsupportedEncodingException;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fedex.common.model.SwakInfo;
import com.fedex.common.util.CommonUtils;
import com.fedex.common.util.KafkaProducerCallBack;

@Component
public class UpStreamClient {

	@Value("${kafka_event_rating_topic}")
	protected String kafka_event_rating_topic;
	
	   

	Logger logger = LoggerFactory.getLogger(UpStreamClient.class);

	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;

	@SuppressWarnings("unchecked")
	void sendMessegae(SwakInfo swakInfo) throws JsonProcessingException, UnsupportedEncodingException {

		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafka_event_rating_topic,
				new String(CommonUtils.convertObjectToJson(swakInfo)));
		future.addCallback(new KafkaProducerCallBack(kafka_event_rating_topic,
				new String(CommonUtils.convertObjectToJson(swakInfo))));
 
		logger.info(swakInfo.toString());       

	}

	@PostConstruct
	public void print1() throws JsonProcessingException, UnsupportedEncodingException {
		
		 
		
		IntStream range = IntStream.rangeClosed(1,5);
		 
		long startTime = System.currentTimeMillis();
		
		 
	
		
		range.parallel().forEach(x -> {
			
           
			try {
				sendMessegae(new SwakInfo(483220, 30, 3, x, "shipmentRoute Indo-US root",
						  1595000727, 1595000727, true, true, "shipmentDetails", 1595000727,
						  "smartPost location", "itemDescription", 1, 20, "billTo",
						  "campushelpdesksyntelinc.com",
						  "Atos Syntel Inc.525 E. Big Beaver Road Suite 300 Troy, MI 48083 United States Tel: +1 (248) 619-2800"
						  , 1234567891, 987456321, 1234567890));
			} catch (JsonProcessingException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        });

		long endTime = System.currentTimeMillis();
		
		double sequentialStreamTimetaken = (endTime - startTime) / 1000;
		
		
		
		logger.info("sent successfully..  "+sequentialStreamTimetaken);

		
		/*
		 * for (int i = 0; i <= 10000; i++) {
		 * 
		 * sendMessegae(new SwakInfo(483220, 30, 3, i, "shipmentRoute Indo-US root",
		 * 1595000727, 1595000727, true, true, "shipmentDetails", 1595000727,
		 * "smartPost location", "itemDescription", 1, 20, "billTo",
		 * "campushelpdesksyntelinc.com",
		 * "Atos Syntel Inc.525 E. Big Beaver Road Suite 300 Troy, MI 48083 United States Tel: +1 (248) 619-2800"
		 * , 1234567891, 987456321, 1234567890));
		 * 
		 * }
		 */
		 

	}

}
