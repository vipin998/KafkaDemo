package com.flightNetWork.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.flightNetWork.model.FlightInfo;
import com.flightNetWork.model.FlightProviders;

public class FlightMapper implements RowMapper<FlightInfo>{

	@Override
	public FlightInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FlightInfo flightInfo = new FlightInfo();
		flightInfo.setDepartureTime(rs.getString("departureTime"));
		flightInfo.setDestination(rs.getString("destination"));
		flightInfo.setDestinationTime(rs.getString("destinationTime"));
		flightInfo.setFlightId(rs.getInt("flightId"));
		flightInfo.setPrice(rs.getInt("price"));
		flightInfo.setOrigin(rs.getString("origin"));
		FlightProviders flightProviders=new FlightProviders();
		flightProviders.setFlightProviderId(rs.getInt("flightproviderid"));
		flightInfo.setFlightProviders(flightProviders);
		return flightInfo;
		
	}
}
