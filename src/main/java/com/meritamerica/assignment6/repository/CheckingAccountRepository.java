package com.meritamerica.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.CheckingAccount;



public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer>{
	List<CheckingAccount> findByAccountHolder(long id);

}
