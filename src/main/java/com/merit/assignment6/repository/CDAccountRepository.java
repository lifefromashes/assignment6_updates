package com.merit.assignment6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merit.assignment6.model.CDAccount;

public interface CDAccountRepository extends JpaRepository<CDAccount, Long> {
	List<CDAccount> findByAccountHolder(long id);

}
