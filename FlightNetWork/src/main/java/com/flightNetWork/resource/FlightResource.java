package com.flightNetWork.resource;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightNetWork.constants.BeanNames;
import com.flightNetWork.model.FlightInfo;
import com.flightNetWork.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author vipin
 *
 */
@Controller
@Api(value = "Flight Info")
public class FlightResource {

	@Autowired
	@Qualifier(BeanNames.FLIGHT_SERVICE)
	FlightService flightService;
	/**
	 * Get request for the resource
	 * 
	 * @return
	 */

	private static final Logger logger = LoggerFactory.getLogger(FlightResource.class);

	@ApiOperation(tags = "FLIGHT NETWORK", value = "get the flight Info", notes = "return the list of flight Info from source to destination")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful request", response = FlightResource.class) })
	@RequestMapping(value = "/searchflight/{origin}/{destination}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Set<FlightInfo> getFlightInfo(HttpServletRequest res,
			@ApiParam(value = "Find the Flight From origin", required = true) @PathVariable(value = "origin") String origin,
			@ApiParam(value = "Find the your Destination", required = true) @PathVariable(value = "destination") String destination) {
		logger.debug("get origin destination list origin{},destination{}", origin, destination);
		return flightService.getFlightInfo(origin, destination);
	}

}
