package com.fedex.common.model;

import java.util.Date;

public class InvoiceDetails

{

	private String billTo;
	private int phoneNo;
	private int invoice;
	private String address;
	private int fax;
	private Date invoiceDate;
	private String email;
	private String ItemDescription;
	private int qty;
	private int discount;
	private String contactName;
	private int invoiceSubTotal;
	private int taxRate;
	private int salesTax;
	private int shippingCost;
	private int depositReceived;
	private int subTotal;

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int getInvoiceSubTotal() {
		return invoiceSubTotal;
	}

	public void setInvoiceSubTotal(int invoiceSubTotal) {
		this.invoiceSubTotal = invoiceSubTotal;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public int getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(int salesTax) {
		this.salesTax = salesTax;
	}

	public int getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}

	public int getDepositReceived() {
		return depositReceived;
	}

	public void setDepositReceived(int depositReceived) {
		this.depositReceived = depositReceived;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [billTo=" + billTo + ", phoneNo=" + phoneNo + ", invoice=" + invoice + ", address="
				+ address + ", fax=" + fax + ", invoiceDate=" + invoiceDate + ", email=" + email + ", ItemDescription="
				+ ItemDescription + ", qty=" + qty + ", discount=" + discount + ", contactName=" + contactName
				+ ", invoiceSubTotal=" + invoiceSubTotal + ", taxRate=" + taxRate + ", salesTax=" + salesTax
				+ ", shippingCost=" + shippingCost + ", depositReceived=" + depositReceived + ", subTotal=" + subTotal
				+ "]";
	}

}
