package com.handballCamp.model;

public class Address {
	private String place;
	private Integer number;
	private String zipCode;
	private String district;
	
	
	public Address(String place, Integer number, String zipCode, String district) {
		super();
		this.place = place;
		this.number = number;
		this.zipCode = zipCode;
		this.district = district;
	}

	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
}
