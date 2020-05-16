package com.merit.assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.AccountHolderContactDetails;

public interface AccountHolderContactDetailsRepository extends JpaRepository<AccountHolderContactDetails, Long>{
	AccountHolderContactDetails findById(long id);
}
