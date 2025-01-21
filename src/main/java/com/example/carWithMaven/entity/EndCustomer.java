package com.example.carWithMaven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EndCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long endCustomerId;

	private String customerName;
	private String contactNumber;
	private String email;
}
