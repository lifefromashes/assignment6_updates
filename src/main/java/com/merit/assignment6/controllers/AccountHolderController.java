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

import com.merit.assignment6.exceptions.NoSuchResourceFoundException;
import com.merit.assignment6.model.AccountHolder;
import com.merit.assignment6.model.AccountHolderContactDetails;
import com.merit.assignment6.repository.AccountHolderContactDetailsRepository;
import com.merit.assignment6.repository.AccountHolderRepository;

@RestController
public class AccountHolderController {

	@Autowired
	private AccountHolderRepository accountHolderRepository;

	@Autowired
	private AccountHolderContactDetailsRepository accountHolderContactDetailsRepository;

	@PostMapping("/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		accountHolderRepository.save(accountHolder);
		return accountHolder;
	}

	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolders() {
		return accountHolderRepository.findAll();
	}

	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable(name = "id") long id) throws NoSuchResourceFoundException {
		AccountHolder accthold = accountHolderRepository.findById(id);
		return accthold;
	}

//	@GetMapping(value = "/AccountHolders/{id}/ContactDetails")
//	@ResponseStatus(HttpStatus.OK)
//	public AccountHolderContactDetails getContactDetails(@PathVariable(name = "id") long id) throws NoSuchResourceFoundException{
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		
//		AccountHolderContactDetails acctDetails = accountHolderContactDetailsRepository.getOne(id);
//		return acctDetails;
//	}

	@GetMapping(value = "/AccountHolders/{id}/ContactDetails")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolderContactDetails> getContactDetails() {
		return accountHolderContactDetailsRepository.findAll();
	}

	@PostMapping(value = "/AccountHolders/{id}/ContactDetails")
	@ResponseStatus(HttpStatus.CREATED)
	public void addContactDetails(@PathVariable(name = "id") long id,
			@RequestBody AccountHolderContactDetails contactDetails) {
		AccountHolder acctholder = accountHolderRepository.findById(id);
		acctholder.setAccountHolderContactDetails(contactDetails);
//		contactDetails.setAccountHolder(acctholder);
		accountHolderRepository.save(acctholder);

	}

}
