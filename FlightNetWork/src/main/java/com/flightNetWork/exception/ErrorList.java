package com.flightNetWork.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErrorList {

	@ApiModelProperty(value = "List of Error Object ", required = true)
	private List<ErrorInfo> errors = new ArrayList<ErrorInfo>();
	@ApiModelProperty(value = "Unique indentifier for this group of error", required = true)
	private String errorId;

	/**
	 * Genrate the unique error Id
	 */
	public ErrorList() {
		this.errorId = UUID.randomUUID().toString();

	}

	/**
	 * @param errors
	 * @param errorId
	 */
	public ErrorList(String errorId, List<ErrorInfo> errors) {
		super();
		this.errors = errors;
		this.errorId = errorId;
	}

	/**
	 * 
	 * @param error
	 */
	public void addError(ErrorInfo error) {
		errors.add(error);

	}

	/**
	 * 
	 * @return
	 */
	public List<ErrorInfo> getErrors() {
		return errors;
	}
	
	

	/**
	 * 
	 * @return
	 */
	@ApiModelProperty(value = "Number of error message return", required = true)
	public int getErorCount() {
		return errors.size();

	}

	public String getErrorId() {
		return errorId;
	}

	
	@Override
	public String toString() {

		try {

			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);

		} catch (JsonProcessingException jpe) {
			jpe.printStackTrace();

		}
		return "(\"error\" : \"Error while Creating the JSON string  from error  object \")";
	}
}
