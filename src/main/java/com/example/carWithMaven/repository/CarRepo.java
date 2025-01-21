package com.example.carWithMaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carWithMaven.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

	List<Car> findByCarOwnerCarOwnerId(Long ownerId);

	List<Car> findByStatus(String string);


}
