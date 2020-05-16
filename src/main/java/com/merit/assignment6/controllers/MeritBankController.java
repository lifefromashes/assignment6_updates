//package com.merit.assignment6.controllers;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.merit.assignment6.exceptions.ExceedsCombinedBalanceLimitException;
//import com.merit.assignment6.exceptions.NegativeAmountException;
//import com.merit.assignment6.exceptions.NoSuchResourceFoundException;
//import com.merit.assignment6.model.AccountHolder;
//import com.merit.assignment6.model.CDAccount;
//import com.merit.assignment6.model.CDOffering;
//import com.merit.assignment6.model.CheckingAccount;
//import com.merit.assignment6.model.MeritBank;
//import com.merit.assignment6.model.SavingsAccount;
//import com.merit.assignment6.repository.AccountHolderContactDetailsRepository;
//import com.merit.assignment6.repository.AccountHolderRepository;
//import com.merit.assignment6.repository.CDAccountRepository;
//import com.merit.assignment6.repository.CheckingAccountRepository;
//import com.merit.assignment6.repository.SavingsAccountRepository;
//
//
//import javassist.NotFoundException;
//
//@RestController
//public class MeritBankController {
//
//	private Logger log = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private AccountHolderRepository accountHolderRepository;
//
//	@Autowired
//	private AccountHolderContactDetailsRepository accountHolderContactDetailsRepository;
//
//	@Autowired
//	private CheckingAccountRepository checkingAccountRepository;
//
//	@Autowired
//	private SavingsAccountRepository savingsAccountRepository;
//
//	@Autowired
//	private CDAccountRepository cdAccountRepository;
//
//	// ==AccountHolders==
//
//	@PostMapping("/AccountHolders")
//	@ResponseStatus(HttpStatus.CREATED)
//	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
//		accountHolderRepository.save(accountHolder);
//		return accountHolder;
//	}
//
//	@GetMapping(value = "/AccountHolders")
//	@ResponseStatus(HttpStatus.OK)
//	public List<AccountHolder> getAccountHolders() {
//		return accountHolderRepository.findAll();
//	}
//
//	@GetMapping(value = "/AccountHolders/{id}")
//	public AccountHolder getAccountHolderById(@PathVariable(name = "id") long id) throws NoSuchResourceFoundException {
//		AccountHolder accthold = accountHolderRepository.findById(id);
//		return accthold;
//	}
//
//	// == CheckingAccounts ==
//
//	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
//	@ResponseStatus(HttpStatus.OK)
//	public List<CheckingAccount> getCheckingAccounts(@PathVariable(name = "id") long id)
//			throws NoSuchResourceFoundException {
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		List<CheckingAccount> chkacc = checkingAccountRepository.findByAccountHolder(acctholder.getId());
//		return chkacc;
//	}
//
//	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CheckingAccount addCheckingAccount(@PathVariable(name = "id") long id,
//			@RequestBody @Valid CheckingAccount checkingAccount)
//			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {
//
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		acctholder.addCheckingAccount(checkingAccount);
//		checkingAccountRepository.save(checkingAccount);
//		return checkingAccount;
//	}
//
//	// == SAVINGS ACCOUNTS ==
//
//	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
//	@ResponseStatus(HttpStatus.OK)
//	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id)
//			throws NoSuchResourceFoundException {
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		List<SavingsAccount> savacc = savingsAccountRepository.findByAccountHolder(acctholder.getId());
//		return savacc;
//	}
//
//	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public SavingsAccount addSavingsAccount(@PathVariable(name = "id") long id,
//			@RequestBody @Valid SavingsAccount savingsAccount)
//			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {
//
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		acctholder.addSavingsAccount(savingsAccount);
//		savingsAccountRepository.save(savingsAccount);
//		return savingsAccount;
//	}
//
//	// == CD ACCOUNTS ==
//
//	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
//	@ResponseStatus(HttpStatus.OK)
//	public List<CDAccount> getCDAccounts(@PathVariable(name = "id") long id) throws NoSuchResourceFoundException {
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		List<CDAccount> cdacc = cdAccountRepository.findByAccountHolder(acctholder.getId());
//		return cdacc;
//	}
//
//	@PostMapping("/AccountHolders/{id}/CDAccounts")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CDAccount addCdAccount(@PathVariable(name = "id") long id, @RequestBody @Valid CDAccount cdAccount)
//			throws ExceedsCombinedBalanceLimitException, NotFoundException, NegativeAmountException {
//
//		AccountHolder acctholder = accountHolderRepository.findById(id);
//		acctholder.addCDAccount(cdAccount);
//		cdAccountRepository.save(cdAccount);
//		return cdAccount;
//	}
//	
//	@CrossOrigin
//	@PostMapping("CDOfferings")
//	@ResponseStatus(HttpStatus.CREATED)
//	public CDOffering createCDOffering(@RequestBody CDOffering cdo) {
//		MeritBank.addCDOffering(cdo);
//		return cdo;
//	}
//	
//	@CrossOrigin
//	@GetMapping("CDOfferings")
//	public List<CDOffering> getCDOfferings() throws NotFoundException {
//		List<CDOffering> cdo = MeritBank.getCDOfferings();
//		return cdo;
//	}
//
//}
