package com.fedex.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

	public static byte[] convertObjectToJson(Object msg) throws JsonProcessingException, UnsupportedEncodingException {

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writeValueAsString(msg);

		return jsonInString.getBytes("UTF-8");

	}

	public static <T> T convertJsonObject(byte[] bytes, Class<T> classObj) throws IOException {

		Object obj = new ObjectMapper().readValue(bytes, classObj);

		return (T) obj;

	}
}
