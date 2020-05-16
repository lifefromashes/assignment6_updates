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
import com.merit.assignment6.model.CheckingAccount;
import com.merit.assignment6.repository.AccountHolderRepository;
import com.merit.assignment6.repository.CheckingAccountRepository;

import javassist.NotFoundException;

@RestController
public class CheckingAccountController {
	
	@Autowired
	private CheckingAccountRepository checkingAccountRepository;
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable(name = "id") long id)
			throws NoSuchResourceFoundException {
		
		
		AccountHolder acctholder = accountHolderRepository.findById(id);
		
		if(acctholder == null) {
			throw new NoSuchResourceFoundException("Invalid Id");
		}
		
		
		List<CheckingAccount> chkacc = checkingAccountRepository.findByAccountHolder(acctholder.getId());
		return chkacc;
	}

	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable(name = "id") long id,
			@RequestBody @Valid CheckingAccount checkingAccount)
			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {

		AccountHolder acctholder = accountHolderRepository.findById(id);
		acctholder.addCheckingAccount(checkingAccount);
		checkingAccountRepository.save(checkingAccount);
		return checkingAccount;
	}
}
