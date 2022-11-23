package com.flightNetWork.exception;


public class ApplicationException extends RuntimeException {

	public static final long serialVersionUID = 1L;
	private ErrorList errors = new ErrorList();

	/**
	 * @param errors
	 */
	public ApplicationException(ErrorInfo error) {

		errors.addError(error);
	}

	/**
	 * Constructor with single ErrorInfo object and the cause
	 * 
	 * @param error
	 * @param cause
	 */
	public ApplicationException(ErrorInfo error, Throwable cause) {

		super(cause);
		errors.addError(error);
	}

	/**
	 * Constructor with jsut the error object
	 * 
	 * @param errors
	 */
	public ApplicationException(ErrorList errors) {

		this.errors = errors;
	}

	/**
	 * Constructor with single ErrorInfo object and the cause
	 * 
	 * @param error
	 * @param cause
	 */
	public ApplicationException(ErrorList errors, Throwable cause) {

		super(cause);
		this.errors = errors;
	}

	/**
	 * 
	 * @param error
	 * @param cause
	 */
	public ApplicationException(String message, ErrorList errors) {

		super(message);
		this.errors = errors;
	}

	/**
	 * 
	 * @param message
	 * @param errors
	 * @param cause
	 */
	public ApplicationException(String message, ErrorList errors, Throwable cause) {

		super(message, cause);
		this.errors = errors;
	}

	/**
	 * 
	 * @return
	 */
	public ErrorList getErrorList() {
		return errors;

	}

}
