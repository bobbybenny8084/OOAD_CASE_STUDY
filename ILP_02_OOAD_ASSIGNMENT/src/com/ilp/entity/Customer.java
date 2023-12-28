package com.ilp.entity;
import com.ilp.entity.Accounts;

import java.util.ArrayList;

public class Customer {
	private String customerCode;
	private String customerName;
	private ArrayList <Accounts> accountList=new ArrayList<Accounts>();
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<Accounts> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Accounts> accountList) {
		this.accountList.addAll(accountList);
	}
	public Customer(String customerCode, String customerName, ArrayList<Accounts> accountList) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.accountList = accountList;
	}
	

}
