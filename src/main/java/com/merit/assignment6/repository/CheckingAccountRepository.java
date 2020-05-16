package com.merit.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.CheckingAccount;



public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long>{
	List<CheckingAccount> findByAccountHolder(long id);

}
