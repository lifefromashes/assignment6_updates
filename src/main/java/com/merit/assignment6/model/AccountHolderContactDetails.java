package com.merit.assignment6.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "account_holder_contact")//, catalog = "MeritAmerica")
public class AccountHolderContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	private String phoneNum;
	private String email;
	private String address;
	
	
	//@OneToOne(mappedBy = "accountHolderContactDetails")
	//@JoinColumn(name = "user_id", referencedColumnName = "user_id")
//	@OneToOne(cascade = CascadeType.ALL)
//	private AccountHolder accountHolder;
	
	public AccountHolderContactDetails() {}

	public long getId() { 
		return id; 
		}
	public void setId(long id) { 
		this.id = id; 
		}
	public String getEmail() { 
		return email; 
		}
	public void setEmail(String email) { 
		this.email = email; 
		}	
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() { return address; }
	public AccountHolderContactDetails setAddress(String address) { this.address = address; return this;}
	

//	public AccountHolder getAccountHolder() { return accountHolder; }
//	public void setAccountHolder(AccountHolder accountHolder) { this.accountHolder = accountHolder; }
	
//	private long accountHolder;
//
//	public long getAccountHolder() {
//		return this.accountHolder;
//	}
//
//	public void setAccountHolder(long n) {
//		this.accountHolder = n;
//	}
	

	
	
}
