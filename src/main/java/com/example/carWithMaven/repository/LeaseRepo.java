package com.example.carWithMaven.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carWithMaven.entity.Car;
import com.example.carWithMaven.entity.EndCustomer;
import com.example.carWithMaven.entity.Lease;

@Repository
public interface LeaseRepo extends JpaRepository<Lease, Long> {

	@Query(value = "SELECT COUNT(*) FROM lease WHERE end_customer_id = :endCustomerId AND is_active = :isActive", nativeQuery = true)
	long countByEndCustomerAndIsActive(EndCustomer endCustomer, boolean b);

	Lease findByCarAndActive(Car car, boolean b);

	List<Lease> findByEndCustomer_EndCustomerId(Long endCustomerId);

}
