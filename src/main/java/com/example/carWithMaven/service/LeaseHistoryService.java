package com.example.carWithMaven.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.carWithMaven.entity.LeaseHistory;
import com.example.carWithMaven.repository.LeaseHistoryRepo;

@Service
public class LeaseHistoryService {
	private LeaseHistoryRepo leaseHistoryRepo;

	public LeaseHistoryService(LeaseHistoryRepo leaseHistoryRepo) {
		this.leaseHistoryRepo = leaseHistoryRepo;
	}

	public List<LeaseHistory> getLeaseHistoryByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		List<LeaseHistory> list = leaseHistoryRepo.findByCarOwnerId(ownerId);
		return list;
	}

}
