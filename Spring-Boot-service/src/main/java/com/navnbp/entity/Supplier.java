package com.navnbp.entity;

import java.io.Serializable;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Supplier implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String name;

	@Embedded
	private Address address;
	@Embedded
	private ContactDetail ContactDetails;
	@OneToOne
	private Supplier leadSupplier;
	private Boolean isLeadSupplier = false;
	private Boolean isThirdParty = false;

	public Supplier() {
	}

	public Supplier(long id, String name, Address address, ContactDetail contactDetails, Supplier leadSupplier,
			boolean isLeadSupplier, boolean isThirdParty) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		ContactDetails = contactDetails;
		this.leadSupplier = leadSupplier;
		this.isLeadSupplier = isLeadSupplier;
		this.isThirdParty = isThirdParty;
	}

	public Boolean getIsLeadSupplier() {
		return isLeadSupplier;
	}

	public void setIsLeadSupplier(Boolean isLeadSupplier) {
		this.isLeadSupplier = isLeadSupplier;
	}

	public Boolean getIsThirdParty() {
		return isThirdParty;
	}

	public void setIsThirdParty(Boolean isThirdParty) {
		this.isThirdParty = isThirdParty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Supplier getLeadSupplier() {
		return leadSupplier;
	}

	public void setLeadSupplier(Supplier leadSupplier) {
		this.leadSupplier = leadSupplier;
	}


	
	public ContactDetail getContactDetails() {
		return ContactDetails;
	}

	public void setContactDetails(ContactDetail contactDetails) {
		ContactDetails = contactDetails;
	}

}
