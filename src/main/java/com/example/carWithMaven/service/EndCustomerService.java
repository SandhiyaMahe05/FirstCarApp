package com.example.carWithMaven.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.carWithMaven.entity.Car;
import com.example.carWithMaven.entity.EndCustomer;
import com.example.carWithMaven.entity.Lease;
import com.example.carWithMaven.exception.NoResourceFoundException;
import com.example.carWithMaven.repository.CarRepo;
import com.example.carWithMaven.repository.EndCustomerRepo;
import com.example.carWithMaven.repository.LeaseRepo;

@Service
public class EndCustomerService {
	private EndCustomerRepo endCustomerRepo;
	private CarRepo carRepo;
	private LeaseRepo leaseRepo;

	public EndCustomerService(EndCustomerRepo endCustomerRepo, CarRepo carRepo, LeaseRepo leaseRepo) {
		this.endCustomerRepo = endCustomerRepo;
		this.carRepo = carRepo;
		this.leaseRepo = leaseRepo;
	}

	public EndCustomer registerEndCustomerDetails(EndCustomer endCustomer) {
		return endCustomerRepo.save(endCustomer);

	}

	public Lease startLease(Long carId, Lease lease) {
		EndCustomer endCustomer = lease.getEndCustomer();
		Car car = carRepo.findById(carId).orElse(null);
		if (car == null) {
			throw new NoResourceFoundException("No cars found");
		}
		long activeLeases = leaseRepo.countByEndCustomerAndIsActive(endCustomer, true);
		if (activeLeases >= 2) {
			throw new RuntimeException("Cannot lease more than 2 cars at a time");
		}

		lease.setCar(car);
		lease.setEndCustomer(endCustomer);
		lease.setLeaseStartDate(new Date());
		lease.setActive(true);

		return leaseRepo.save(lease);
	}
	
	public void endLease(Long carId) {
	
		Car car = carRepo.findById(carId).orElse(null);

		Lease lease = leaseRepo.findByCarAndActive(car, true);
		lease.setActive(false); 
		lease.setLeaseEndDate(new Date());
		leaseRepo.save(lease);

	}

	public List<Car> getCarsStatus() {
		return carRepo.findAll();
	}

	public List<Lease> getLeaseHistory(Long endCustomerId) {
        return leaseRepo.findByEndCustomer_EndCustomerId(endCustomerId);
	}

}
