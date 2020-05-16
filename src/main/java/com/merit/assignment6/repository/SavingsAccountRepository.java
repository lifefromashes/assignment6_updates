package com.merit.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long>{
	List<SavingsAccount> findByAccountHolder(long id);

}
