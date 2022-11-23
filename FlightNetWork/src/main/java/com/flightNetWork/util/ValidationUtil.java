package com.flightNetWork.util;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.flightNetWork.errorconstant.ErrorConstant;
import com.flightNetWork.exception.ErrorInfo;
import com.flightNetWork.exception.ErrorList;
import com.flightNetWork.exception.NotFoundException;
import com.flightNetWork.model.FlightInfo;

public class ValidationUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(ValidationUtil.class);
	

	public static void validateFlightInfo(Set<FlightInfo> flightInfos) {
		
		if(flightInfos.isEmpty()) {
			
			ErrorList errorList=new ErrorList();
			
			logger.error("flight is not exit in db {}",flightInfos);
			
			errorList.addError(new ErrorInfo(ErrorConstant.FLIGHT_NOT_FPOUND, "flight not found"));
			throw new NotFoundException(errorList) ;
		}
		
		
	}
}
