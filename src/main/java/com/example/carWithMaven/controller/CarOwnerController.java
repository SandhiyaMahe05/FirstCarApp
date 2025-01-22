package com.example.carWithMaven.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carWithMaven.entity.Car;
import com.example.carWithMaven.entity.CarOwner;
import com.example.carWithMaven.entity.LeaseHistory;
import com.example.carWithMaven.exception.NoResourceFoundException;
import com.example.carWithMaven.service.CarOwnerService;
import com.example.carWithMaven.service.CarService;
import com.example.carWithMaven.service.LeaseHistoryService;

@RestController
@RequestMapping("/carOwner")
public class CarOwnerController {
	private CarService carService;
	private CarOwnerService carOwnerService;
	private LeaseHistoryService leaseHistoryService;

	public CarOwnerController(CarService carService, CarOwnerService carOwnerService,
			LeaseHistoryService leaseHistoryService) {
		this.carService = carService;
		this.carOwnerService = carOwnerService;
		this.leaseHistoryService = leaseHistoryService;
	}

	@PostMapping("/registerCarOwner")
	public ResponseEntity<String> registerCarOwner(@RequestBody CarOwner carOwner) {
		CarOwner savedCarOwner = carOwnerService.registerCarOwner(carOwner);
		return ResponseEntity.ok("Car Owner Registered Successfully, OwnerId is: " + savedCarOwner.getCarOwnerId());
	}

	@PostMapping("/enrollCar")
	public ResponseEntity<String> enrollCar(@RequestBody Car car) {
		Car enrolledCar = carService.enrollCar(car);
		return ResponseEntity.ok("Car enrolled successfully");
	}

	@GetMapping("/carListOfOwner/{id}")
	public ResponseEntity<List<Car>> getAllCarsByOwner(@PathVariable Long id) {
		List<Car> cars = carService.getCarsByOwnerId(id);
		if (cars.isEmpty()) {
			throw new NoResourceFoundException("No cars found for this owner.");
		}
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/leaseHistory/{ownerId}")
	public ResponseEntity<List<LeaseHistory>> getLeaseHistory(@PathVariable Long ownerId) {
		List<LeaseHistory> leaseHistories = leaseHistoryService.getLeaseHistoryByOwnerId(ownerId);
		if (leaseHistories.isEmpty()) {
			throw new NoResourceFoundException("No lease history found for this owner.");
		}
		return ResponseEntity.ok(leaseHistories);
	}
}
