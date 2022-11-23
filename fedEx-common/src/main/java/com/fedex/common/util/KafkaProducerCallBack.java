package com.fedex.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class KafkaProducerCallBack implements ListenableFutureCallback {

	private String topicName;
	private String message;

	static final Logger logger = LoggerFactory.getLogger(KafkaProducerCallBack.class);

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public KafkaProducerCallBack(String topicName, String message) {

		this.topicName = topicName;
		this.message = message;
	}

	@Override
	public void onSuccess(Object arg0) {
// TODO Auto-generated method stub

	}

	@Override
	public void onFailure(Throwable ex) {
// TODO Auto-generated method stub
		logger.error("[ KafkaWriteExceptionMsg::] Topic:{} Message: {}", topicName, message);
		logger.error("[ KafkaWriteException::] " + ex.getLocalizedMessage());
	}

}
