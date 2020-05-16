package com.merit.assignment6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.merit.assignment6.model.AccountHolder;
import com.merit.assignment6.model.CDOffering;
import com.merit.assignment6.repository.AccountHolderRepository;
import com.merit.assignment6.repository.CDOfferingRepository;

import javassist.NotFoundException;

public class CDOfferingsController {
	
	@Autowired
	private CDOfferingRepository cdOfferingRepository;
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@RequestBody CDOffering cdOffering) {
		
		
		cdOfferingRepository.save(cdOffering);
		return cdOffering;
		
	}
	
	@GetMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<CDOffering> getCDOfferings() throws NotFoundException {
		return cdOfferingRepository.findAll();
	}
}