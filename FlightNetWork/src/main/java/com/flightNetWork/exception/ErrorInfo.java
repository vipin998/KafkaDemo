package com.flightNetWork.exception;

import java.util.StringJoiner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is used to provide the error info
 * @author Vipin
 *
 */
@ApiModel
public class ErrorInfo {

	@ApiModelProperty(value = "Application specific error code", required = true)

	private String errorCode;

	@ApiModelProperty(value = "Devloper provide error message", required = true)

	private String massage;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the massage
	 */
	public String getMassage() {
		return massage;
	}

	/**
	 * This method provide the error info 
	 * @param errorCode
	 * @param massages
	 */
	public ErrorInfo(String errorCode, String... massages) {

		this.errorCode = errorCode;

		StringJoiner joiner = new StringJoiner(" ");

		for (String massage : massages) {

			joiner.add(massage);

		}
		this.massage=joiner.toString();
	}
	
	
}
