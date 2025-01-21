package com.example.carWithMaven.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.carWithMaven.entity.Car;
import com.example.carWithMaven.entity.CarOwner;
import com.example.carWithMaven.entity.LeaseHistory;
import com.example.carWithMaven.exception.NoResourceFoundException;
import com.example.carWithMaven.repository.CarOwnerRepo;
import com.example.carWithMaven.repository.CarRepo;
import com.example.carWithMaven.repository.LeaseHistoryRepo;



@Service
public class CarService {

	private CarRepo carRepo;
	private CarOwnerRepo carOwnerRepo;
	private LeaseHistoryRepo leaseHistoryRepo;

	public CarService(CarRepo carRepo, CarOwnerRepo carOwnerRepo) {
		this.carRepo = carRepo;
		this.carOwnerRepo=carOwnerRepo;
	}

	public Car enrollCar(Car car) {
		CarOwner carOwner = carOwnerRepo.findById(car.getCarOwner().getCarOwnerId())
	                                               .orElse(null);
	        if (carOwner == null) {
	        	throw new NoResourceFoundException("Owner not found so Couldn't register");
	        }
	        car.setCarOwner(carOwner);
	        return carRepo.save(car);
	    }

	public List<Car> getCarsByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		  return carRepo.findByCarOwnerCarOwnerId(ownerId);
	}

	public List<Car> getAvailableCarForLease() {
		return carRepo.findByStatus("Ideal");
	}
	

}
