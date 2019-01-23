package com.capgemini.bankWebApp.transactionService.service;

import java.util.List;

import com.capgemini.bankWebApp.transactionService.entity.Transaction;

public interface TransactionService {

	Double deposit(Integer accountNumber, Double currentBalance, Double amount);

	Double saveTransaction(Integer accountNumber, Double currentBalance, Double amount, String transactionType);

	List<Transaction> getAllTransactions();

}
