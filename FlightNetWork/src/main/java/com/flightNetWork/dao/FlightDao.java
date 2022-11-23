package com.flightNetWork.dao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flightNetWork.constants.BeanNames;
import com.flightNetWork.mapper.FlightMapper;
import com.flightNetWork.model.FlightInfo;

/**
 * This class work as repository
 * @author vipin
 *
 */

@Repository(BeanNames.FLIGHT_DAO)
public class FlightDao {

	private static final Logger logger = LoggerFactory.getLogger(FlightDao.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final String  GET_FLIGHT_INFO="select " + 
			"   flightid," + 
			" 	departuretime," + 
			" 	destination," + 
			" 	destinationtime	," + 
			" 	price," + 
			" 	origin," + 
			" 	flightproviderid" + 			
			"   from flightInfo" +
			"   where origin = :origin "+
			"   AND"+
			"   destination= :destination "+
			"   order by price ,destination desc";
	
	/**
	 * Get the flight information from table
	 * @param origin
	 * @param destination
	 * @return
	 */
	
	public Set<FlightInfo> getFlightInfo(String origin, String destination) {
	
		MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
		mapSqlParameterSource.addValue("origin", origin);
		mapSqlParameterSource.addValue("destination", destination);
		List<FlightInfo> query = namedParameterJdbcTemplate.query(GET_FLIGHT_INFO,mapSqlParameterSource,new FlightMapper());
		logger.debug("retrive the all flight list{}",query);
		Set<FlightInfo> set=new HashSet<FlightInfo>();
		set.addAll(query);
		return set;
	}

}
