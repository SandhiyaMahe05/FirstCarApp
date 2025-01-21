package com.example.carWithMaven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carOwnerId;
	private String carOwnerName;
	private Long contactNumber;
	private String email;

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		if (contactNumber == null || String.valueOf(contactNumber).length() != 10) {
			throw new IllegalArgumentException("Contact number must be a 10-digit number");
		}
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new IllegalArgumentException("Invalid email format");
		}
		this.email = email;
	}

	public String getCarOwnerName() {
		return carOwnerName;
	}

	public void setCarOwnerName(String ownerName) {
		if (ownerName == null || ownerName.trim().isEmpty()) {
			throw new IllegalArgumentException("Owner name cannot be null or empty");
		}
		this.carOwnerName = ownerName;
	}
	public Long getCarOwnerId() {
		return carOwnerId;
	}

	public void setCarOwnerId(Long carOwnerId) {
		
		this.carOwnerId = carOwnerId;
	}

}
