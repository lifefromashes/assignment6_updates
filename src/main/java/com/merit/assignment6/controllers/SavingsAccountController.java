package com.merit.assignment6.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.merit.assignment6.exceptions.ExceedsCombinedBalanceLimitException;
import com.merit.assignment6.exceptions.NegativeAmountException;
import com.merit.assignment6.exceptions.NoSuchResourceFoundException;
import com.merit.assignment6.model.AccountHolder;
import com.merit.assignment6.model.SavingsAccount;
import com.merit.assignment6.repository.AccountHolderRepository;
import com.merit.assignment6.repository.SavingsAccountRepository;

import javassist.NotFoundException;

@RestController
public class SavingsAccountController {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id)
			throws NoSuchResourceFoundException {
		AccountHolder acctholder = accountHolderRepository.findById(id);
		List<SavingsAccount> savacc = savingsAccountRepository.findByAccountHolder(acctholder.getId());
		return savacc;
	}

	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable(name = "id") long id,
			@RequestBody @Valid SavingsAccount savingsAccount)
			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {

		AccountHolder acctholder = accountHolderRepository.findById(id);
		acctholder.addSavingsAccount(savingsAccount);
		savingsAccountRepository.save(savingsAccount);
		return savingsAccount;
	}

}
