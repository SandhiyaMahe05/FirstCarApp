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
public class LeaseHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaseId;
	private String lesseeName;
	private Date startDate;
	private Date endDate;
	private Long carOwnerId;
	private Long endCustomerId;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
}
