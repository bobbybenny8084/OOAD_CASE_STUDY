package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Products {
	int minimumBalance=1000;

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> productServicelist) {
		super(productCode, productName, productServicelist);
		// TODO Auto-generated constructor stub
	}

	public int getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

}
