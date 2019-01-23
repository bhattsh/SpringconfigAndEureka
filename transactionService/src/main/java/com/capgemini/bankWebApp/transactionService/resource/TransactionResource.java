package com.capgemini.bankWebApp.transactionService.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bankWebApp.transactionService.entity.CurrentDataSet;
import com.capgemini.bankWebApp.transactionService.entity.Transaction;
import com.capgemini.bankWebApp.transactionService.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private RestTemplate restTemplate;

	
	@PostMapping
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {

		ResponseEntity<Double> entity = restTemplate.getForEntity(
				"http://account-service/accounts/" + transaction.getAccountNumber() + "/balance", Double.class);
		Double currentBalance = entity.getBody();

		if (transaction.getTransactionType().equalsIgnoreCase("deposit")) {
			Double updateBalance = transactionService.saveTransaction(transaction.getAccountNumber(), currentBalance,
					transaction.getAmount(), transaction.getTransactionType());
			restTemplate.put("http://account-service/accounts/" + transaction.getAccountNumber() + "?currentBalance="
					+ updateBalance, null);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		else if (transaction.getTransactionType().equalsIgnoreCase("withdraw")) {
			Double updateBalance = transactionService.saveTransaction(transaction.getAccountNumber(), currentBalance,
					transaction.getAmount(), transaction.getTransactionType());
			restTemplate.put("http://account-service/accounts/" + transaction.getAccountNumber() + "?currentBalance="
					+ updateBalance, null);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return null;
		}

	}


	@GetMapping
	public ResponseEntity<CurrentDataSet> getTransactions(){
		
		CurrentDataSet currentDataSet =new CurrentDataSet();
		List<Transaction> transactions = transactionService.getAllTransactions();
		currentDataSet.setTransactions(transactions);
		return new ResponseEntity<>(currentDataSet, HttpStatus.OK);
	}
	
	
	
	
	/*
	 * @PostMapping public ResponseEntity<Transaction> deposit(@RequestBody
	 * Transaction transaction) {
	 * 
	 * ResponseEntity<Double> entity = restTemplate.getForEntity(
	 * "http://localhost:9090/accounts/" + transaction.getAccountNumber() +
	 * "/balance", Double.class);
	 * 
	 * Double currentBalance = entity.getBody();
	 * 
	 * Double updateBalance =
	 * transactionService.deposit(transaction.getAccountNumber(), currentBalance,
	 * transaction.getAmount());
	 * 
	 * restTemplate.put( "http://localhost:9090/accounts/" +
	 * transaction.getAccountNumber() + "?currentBalance=" + updateBalance, null);
	 * return new ResponseEntity<>(HttpStatus.CREATED);
	 * 
	 * }
	 */

}
