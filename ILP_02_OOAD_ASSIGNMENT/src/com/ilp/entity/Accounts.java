package com.ilp.entity;

public class Accounts {
	private String accountNo;
	private String accountType; 
	private double balance;
	private Products product;
	
	public Accounts(String accountNo, String accountType, double balance, Products product) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.product = product;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Products getProduct() {
		return product;
	}
	
	public void setProduct(Products product) {
		this.product = product;
	}

}