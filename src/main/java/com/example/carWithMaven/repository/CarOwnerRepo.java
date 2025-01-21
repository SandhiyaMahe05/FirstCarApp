package com.example.carWithMaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carWithMaven.entity.CarOwner;

@Repository
public interface CarOwnerRepo extends JpaRepository<CarOwner,Long>{

}
