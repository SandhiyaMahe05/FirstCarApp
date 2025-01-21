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
import com.example.carWithMaven.entity.EndCustomer;
import com.example.carWithMaven.entity.Lease;
import com.example.carWithMaven.service.CarService;
import com.example.carWithMaven.service.EndCustomerService;

@RestController
@RequestMapping("endCustomer")
public class EndCustomerController {

	private EndCustomerService endCustomerService;
	private CarService carService;

	public EndCustomerController(EndCustomerService endCustomerService, CarService carService) {
		this.endCustomerService = endCustomerService;
		this.carService = carService;
	}

	@PostMapping("/registerEndCustomer")
	public ResponseEntity<String> registerEndCustomer(@RequestBody EndCustomer endCustomer) {
		endCustomerService.registerEndCustomerDetails(endCustomer);
		return ResponseEntity.ok("EndCustomer Registered Successfully");
	}

	@GetMapping("/availableCarsForLease")
	public ResponseEntity<List<Car>> availableCarsForLease() {
		List<Car> carList = carService.getAvailableCarForLease();
		return ResponseEntity.ok(carList);
	}

	@PostMapping("/startLease/{carId}")
	public ResponseEntity<Lease> startLease(@PathVariable Long carId, @RequestBody Lease lease) {
		Lease startedLease = endCustomerService.startLease(carId, lease);
		return ResponseEntity.ok(startedLease);

	}

	@PostMapping("/endLease/{carId}")
	public ResponseEntity<?> endLease(@PathVariable Long carId) {
		endCustomerService.endLease(carId);
		return ResponseEntity.ok("Lease ended successfully for car ID: " + carId);
	}

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getCars() {
		List<Car> cars = endCustomerService.getCarsStatus();
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Lease>> getLeaseHistory(@RequestBody Long endCustomerId) {
		List<Lease> history = endCustomerService.getLeaseHistory(endCustomerId);
		return ResponseEntity.ok(history);
	}

}
