package com.capgemini.bankWebApp.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankWebApp.account.entity.SavingsAccount;
import com.capgemini.bankWebApp.account.repo.SavingsRepository;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

	@Autowired
	private SavingsRepository repository;
	
	public void addNewAccount(SavingsAccount account) {
		repository.save(account);
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() {
		 return repository.findAll();
	}

	@Override
	public Optional<SavingsAccount> getSavingAccountById(Integer accountNumber) {
		return repository.findById(accountNumber);
	}

	@Override
	public void deleteSavingAccount(SavingsAccount savingsAccount) {
		repository.delete(savingsAccount);
		
	}
}
