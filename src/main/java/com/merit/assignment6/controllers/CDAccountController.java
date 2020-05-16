package com.merit.assignment6.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.merit.assignment6.model.CDAccount;
import com.merit.assignment6.model.CDOffering;
import com.merit.assignment6.model.MeritBank;
import com.merit.assignment6.repository.AccountHolderRepository;
import com.merit.assignment6.repository.CDAccountRepository;

import javassist.NotFoundException;




@RestController
public class CDAccountController {

	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	@Autowired
	private CDAccountRepository cdAccountRepository;
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccounts(@PathVariable(name = "id") long id) throws NoSuchResourceFoundException {
		AccountHolder acctholder = accountHolderRepository.findById(id);
		List<CDAccount> cdacc = cdAccountRepository.findByAccountHolder(acctholder.getId());
		return cdacc;
	}

	@PostMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCdAccount(@PathVariable(name = "id") long id, @RequestBody @Valid CDAccount cdAccount)
			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {

		AccountHolder acctholder = accountHolderRepository.findById(id);
		acctholder.addCDAccount(cdAccount);
		cdAccountRepository.save(cdAccount);
		return cdAccount;
	}
	
	@CrossOrigin
	@PostMapping("CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@RequestBody CDOffering cdo) {
		MeritBank.addCDOffering(cdo);
		return cdo;
	}
	
	@CrossOrigin
	@GetMapping("CDOfferings")
	public List<CDOffering> getCDOfferings() throws NotFoundException {
		List<CDOffering> cdo = MeritBank.getCDOfferings();
		return cdo;
	}
}
