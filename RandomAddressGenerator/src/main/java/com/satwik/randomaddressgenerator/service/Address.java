package com.satwik.randomaddressgenerator.service;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Address {
	
	private String house;
	
	private String street;
	
	private String postalCode;
	
	private String city;
	
	private String county;
	
	private String  state;
	
	private String stateCode;
	
	private String country;
	
	private String countryCode;

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("house", house);
		builder.append("street", street);
		builder.append("postalCode", postalCode);
		builder.append("city", city);
		builder.append("county", county);
		builder.append("state", state);
		builder.append("stateCode", stateCode);
		builder.append("country", country);
		builder.append("countryCode", countryCode);
		return builder.toString();
	}

}
