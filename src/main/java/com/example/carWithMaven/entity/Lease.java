package com.example.carWithMaven.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Lease {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaseId;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@ManyToOne
	@JoinColumn(name = "end_customer_id")
	private EndCustomer endCustomer;

	private Date leaseStartDate;

	private Date leaseEndDate;

	private boolean active;

}
