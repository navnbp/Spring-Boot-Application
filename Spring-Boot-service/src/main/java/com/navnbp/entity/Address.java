package com.navnbp.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class Address implements Serializable  {

	private String address;
	private String city;
	private String state;
	private String zip;

	public Address() {}
	
	public Address(String address, String city, String state, String zip) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
