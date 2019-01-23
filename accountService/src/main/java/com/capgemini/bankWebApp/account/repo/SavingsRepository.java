package com.capgemini.bankWebApp.account.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bankWebApp.account.entity.SavingsAccount;

@Repository
public interface SavingsRepository extends MongoRepository<SavingsAccount, Integer> {
	
}
