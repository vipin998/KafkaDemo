package com.fedex.common.model;

public class SwakInfo {

	private int destinationZipCode;

	private int weigh;

	private int bookingNumber;

	private int containerNumber;

	private String shipmentRoute;

	private long estimatedTimeCompletion;

	private long estimatedTimeDeparture;

	private boolean fullContainerLoad;

	private boolean paymentStatus;

	private String shipmentDetails;

	private long shipmentCutoffTime;

	private String smartPost;

	private String ItemDescription;
	private int qty;
	private int discount;

	private String billTo;
	private String email;
	private String address;
	private int phoneNumber;
	private int bussinessNumber;
	private int fax;

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getBussinessNumber() {
		return bussinessNumber;
	}

	public void setBussinessNumber(int bussinessNumber) {
		this.bussinessNumber = bussinessNumber;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public int getDestinationZipCode() {
		return destinationZipCode;
	}

	public void setDestinationZipCode(int destinationZipCode) {
		this.destinationZipCode = destinationZipCode;
	}

	public int getWeigh() {
		return weigh;
	}

	public void setWeigh(int weigh) {
		this.weigh = weigh;
	}

	public int getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public int getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(int containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getShipmentRoute() {
		return shipmentRoute;
	}

	public void setShipmentRoute(String shipmentRoute) {
		this.shipmentRoute = shipmentRoute;
	}

	public long getEstimatedTimeCompletion() {
		return estimatedTimeCompletion;
	}

	public void setEstimatedTimeCompletion(long estimatedTimeCompletion) {
		this.estimatedTimeCompletion = estimatedTimeCompletion;
	}

	public long getEstimatedTimeDeparture() {
		return estimatedTimeDeparture;
	}

	public void setEstimatedTimeDeparture(long estimatedTimeDeparture) {
		this.estimatedTimeDeparture = estimatedTimeDeparture;
	}

	public boolean isFullContainerLoad() {
		return fullContainerLoad;
	}

	public void setFullContainerLoad(boolean fullContainerLoad) {
		this.fullContainerLoad = fullContainerLoad;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShipmentDetails() {
		return shipmentDetails;
	}

	public void setShipmentDetails(String shipmentDetails) {
		this.shipmentDetails = shipmentDetails;
	}

	public long getShipmentCutoffTime() {
		return shipmentCutoffTime;
	}

	public void setShipmentCutoffTime(long shipmentCutoffTime) {
		this.shipmentCutoffTime = shipmentCutoffTime;
	}

	public String getSmartPost() {
		return smartPost;
	}

	public void setSmartPost(String smartPost) {
		this.smartPost = smartPost;
	}

	public String getItemDescription() {
		return ItemDescription;
	}

	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public SwakInfo() {
		super();
	}

	public SwakInfo(int destinationZipCode, int weigh, int bookingNumber, int containerNumber, String shipmentRoute,
			long estimatedTimeCompletion, long estimatedTimeDeparture, boolean fullContainerLoad, boolean paymentStatus,
			String shipmentDetails, long shipmentCutoffTime, String smartPost, String itemDescription, int qty,
			int discount, String billTo, String email, String address, int phoneNumber, int bussinessNumber, int fax) {
		super();
		this.destinationZipCode = destinationZipCode;
		this.weigh = weigh;
		this.bookingNumber = bookingNumber;
		this.containerNumber = containerNumber;
		this.shipmentRoute = shipmentRoute;
		this.estimatedTimeCompletion = estimatedTimeCompletion;
		this.estimatedTimeDeparture = estimatedTimeDeparture;
		this.fullContainerLoad = fullContainerLoad;
		this.paymentStatus = paymentStatus;
		this.shipmentDetails = shipmentDetails;
		this.shipmentCutoffTime = shipmentCutoffTime;
		this.smartPost = smartPost;
		ItemDescription = itemDescription;
		this.qty = qty;
		this.discount = discount;
		this.billTo = billTo;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bussinessNumber = bussinessNumber;
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "SwakInfo [destinationZipCode=" + destinationZipCode + ", weigh=" + weigh + ", bookingNumber="
				+ bookingNumber + ", containerNumber=" + containerNumber + ", shipmentRoute=" + shipmentRoute
				+ ", estimatedTimeCompletion=" + estimatedTimeCompletion + ", estimatedTimeDeparture="
				+ estimatedTimeDeparture + ", fullContainerLoad=" + fullContainerLoad + ", paymentStatus="
				+ paymentStatus + ", shipmentDetails=" + shipmentDetails + ", shipmentCutoffTime=" + shipmentCutoffTime
				+ ", smartPost=" + smartPost + ", ItemDescription=" + ItemDescription + ", qty=" + qty + ", discount="
				+ discount + ", billTo=" + billTo + ", email=" + email + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", bussinessNumber=" + bussinessNumber + ", fax=" + fax + "]";
	}

}
