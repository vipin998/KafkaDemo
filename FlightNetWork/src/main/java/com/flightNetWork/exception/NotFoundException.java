package com.flightNetWork.exception;

public class NotFoundException extends ApplicationException {


	public static final long serialVersionUID = 1L;

	public NotFoundException(ErrorInfo error) {

		super(error);
	}
	public NotFoundException(ErrorInfo error, Throwable cause) {

		super(error ,cause);
	}

	public NotFoundException(ErrorList errors) {

		super(errors);
	}
	
	public NotFoundException(ErrorList errors, Throwable cause) {

		super(errors ,cause);
	}

	/**
	 * 
	 * @param message
	 * @param errors
	 * @param cause
	 */
	public NotFoundException(String message, ErrorList errors, Throwable cause) {

		super(message,errors ,cause);
		
	}

	
}
