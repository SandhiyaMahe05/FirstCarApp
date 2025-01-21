package com.example.carWithMaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carWithMaven.entity.EndCustomer;

@Repository
public interface EndCustomerRepo extends JpaRepository<EndCustomer, Long> {

}
