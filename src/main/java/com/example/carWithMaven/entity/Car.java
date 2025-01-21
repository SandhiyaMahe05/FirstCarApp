package com.example.carWithMaven.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;

	private String name;
	private String model;
	private String registrationNumber;
	private String status;

	@ManyToOne
	@JoinColumn(name = "car_Owner_Id")
	private CarOwner carOwner;

	@OneToMany(mappedBy = "car")
	private List<LeaseHistory> leaseHistory;

}
