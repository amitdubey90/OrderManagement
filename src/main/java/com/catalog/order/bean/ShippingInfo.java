package com.catalog.order.bean;

public class ShippingInfo {
	private String zipCode;
	private String fullName;
	private String streetAddress; 	
	private String town;	
	private String state;
	private String contact;
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "ShippingInfo [zipCode=" + zipCode + ", fullName=" + fullName
				+ ", streetAddress=" + streetAddress + ", town=" + town
				+ ", state=" + state + ", contact=" + contact + "]";
	}
	
}
