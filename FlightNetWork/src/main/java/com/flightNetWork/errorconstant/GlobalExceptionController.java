package com.flightNetWork.errorconstant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.flightNetWork.exception.NotFoundException;
/**
 * This class is used to handel all application exception
 * @author vipin
 *
 */
@ControllerAdvice
public class GlobalExceptionController {

	public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
/**
 * This method is used to handel the not_foud exception 
 * @param e
 * @return
 */
	@ExceptionHandler
	public ResponseEntity<String> handelApplicationException(NotFoundException e) {

		return new ResponseEntity<String>(e.getErrorList().toString(),HttpStatus.NOT_FOUND);

	}

	
}
