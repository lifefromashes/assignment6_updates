package com.meritamerica.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.AccountHolder;


public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
	AccountHolder findbyId(long id);
	
	

}
