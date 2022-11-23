package com.flightNetWork.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.flightNetWork.constants.BeanNames;
import com.flightNetWork.dao.FlightDao;
import com.flightNetWork.model.FlightInfo;
import com.flightNetWork.resource.FlightResource;
import com.flightNetWork.util.ValidationUtil;

/**This is service class to handel the flight request
 * 
 * @author vipin
 *
 */

@Service(BeanNames.FLIGHT_SERVICE)
public class FlightService {

	private static final Logger logger = LoggerFactory.getLogger(FlightService.class);
	@Autowired
	@Qualifier(BeanNames.FLIGHT_DAO)
	FlightDao flightDao;
	
	/**
	 * This method is used to get the flight details
	 * @param origin
	 * @param destination
	 * @return
	 */
	
	public Set<FlightInfo> getFlightInfo(String origin, String destination) {
		Set<FlightInfo> flightInfos = flightDao.getFlightInfo(origin, destination);
		logger.debug("get origin destination list flightInfos{}", flightInfos);
		if(flightInfos.isEmpty()) {
		
			ValidationUtil.validateFlightInfo(flightInfos);	
			
			
		}
		return flightInfos;
	}

}
