package com.capgemini.bankWebApp.account.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.bankWebApp.account.entity.SavingsAccount;

public interface SavingsAccountService {

	void addNewAccount(SavingsAccount account);

	List<SavingsAccount> getAllSavingsAccount();

	Optional<SavingsAccount> getSavingAccountById(Integer accountNumber);

	void deleteSavingAccount(SavingsAccount savingsAccount);

}
