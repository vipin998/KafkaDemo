package com.flightNetWork.model;

import io.swagger.annotations.ApiModel;

/**
 * THis class is used as
 * 
 * @author vipin
 *
 */
@ApiModel

public class FlightInfo {

	private Integer flightId;
	private String origin;
	private String destination;
	private String departureTime;
	private String destinationTime;
	private Integer price;
	private FlightProviders flightProviders;
	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the destinationTime
	 */
	public String getDestinationTime() {
		return destinationTime;
	}
	/**
	 * @param destinationTime the destinationTime to set
	 */
	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the flightId
	 */
	public Integer getFlightId() {
		return flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the flightProviders
	 */
	public FlightProviders getFlightProviders() {
		return flightProviders;
	}
	/**
	 * @param flightProviders the flightProviders to set
	 */
	public void setFlightProviders(FlightProviders flightProviders) {
		this.flightProviders = flightProviders;
	}

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightInfo [departureTime=" + departureTime + ", destination=" + destination + ", destinationTime="
				+ destinationTime + ", price=" + price + ", flightId=" + flightId + ", origin=" + origin
				+ ", flightProviders=" + flightProviders + "]";
	}
	
	
	
	
}
