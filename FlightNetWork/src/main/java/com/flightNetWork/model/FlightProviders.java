package com.flightNetWork.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author vipin
 *
 */

@JsonInclude(Include.NON_NULL)
public class FlightProviders {

	private Integer flightProviderId;
	private String FlightProviderName;
	private Set<FlightInfo> flightInfo;
	/**
	 * @return the flightProviderId
	 */
	public Integer getFlightProviderId() {
		return flightProviderId;
	}
	/**
	 * @param flightProviderId the flightProviderId to set
	 */
	public void setFlightProviderId(Integer flightProviderId) {
		this.flightProviderId = flightProviderId;
	}
	/**
	 * @return the flightProviderName
	 */
	public String getFlightProviderName() {
		return FlightProviderName;
	}
	/**
	 * @param flightProviderName the flightProviderName to set
	 */
	public void setFlightProviderName(String flightProviderName) {
		FlightProviderName = flightProviderName;
	}
	/**
	 * @return the flightInfo
	 */
	public Set<FlightInfo> getFlightInfo() {
		return flightInfo;
	}
	/**
	 * @param flightInfo the flightInfo to set
	 */
	public void setFlightInfo(Set<FlightInfo> flightInfo) {
		this.flightInfo = flightInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightProviders [flightProviderId=" + flightProviderId + ", FlightProviderName=" + FlightProviderName
				+ ", flightInfo=" + flightInfo + "]";
	}
}
