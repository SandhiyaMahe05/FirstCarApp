package com.example.carWithMaven.service;

import org.springframework.stereotype.Service;

import com.example.carWithMaven.entity.CarOwner;
import com.example.carWithMaven.repository.CarOwnerRepo;



@Service
public class CarOwnerService {
private CarOwnerRepo carOwnerRepo;

public CarOwnerService(CarOwnerRepo carOwnerRepo) {
	this.carOwnerRepo=carOwnerRepo;
}
	
	public CarOwner registerCarOwner(CarOwner carOwner) {
		// TODO Auto-generated method stub
		return carOwnerRepo.save(carOwner);
	}

	

}
