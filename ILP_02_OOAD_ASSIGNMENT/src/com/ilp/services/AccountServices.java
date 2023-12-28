package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Accounts;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Products;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class AccountServices {
	
	//create services

	public static Service createService() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Service Code: \n");
		String serviceCode=scanner.next();
		System.out.println("Enter Service Name: \n");
		String serviceName=scanner.next();
		System.out.println("Enter Service Rate: \n");
		int rate=scanner.nextInt();
		System.out.println("Service Created \n");
		Service service=new Service(serviceCode,serviceName,rate);
		return service;
	}
	
	//create products

	public static Products createProduct(ArrayList<Service> servicelist) {
		
		ArrayList <Service> productServicelist=new ArrayList <Service>();
		int serviceChoice=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Code: \n");
		String productCode=scanner.next();
		System.out.println("Enter Product Name: \n");
		String productName=scanner.next();
		System.out.println("These are the available Services:  \n");
		System.out.println("Service code"+" " +"Service name"+" "+"Service rate");
		for(Service service: servicelist) {
			
			System.out.println(service.getServiceCode()+"\t \t "+service.getServiceName()+" \t \t"+service.getRate());
		}
		while(serviceChoice==0) {	
			System.out.println("Enter the Service code to add service: \n");
			String serviceCode=scanner.next();
	        for(Service service: servicelist) {
	        	
	        	if(serviceCode.equalsIgnoreCase(service.getServiceCode())) {
	        		productServicelist.add(service);
	        		System.out.println("added");
	        		
	        	}
				
			}
	        System.out.println("Enter '0' to add more service / Enter '1' to exit ");
			serviceChoice=scanner.nextInt();
		}
		
		System.out.println("Product Created \n");
		if(productName.equalsIgnoreCase("SavingsMax")) {
			SavingsMaxAccount product=new SavingsMaxAccount(productCode,productName,productServicelist);
			return product;
		}
		else if(productName.equalsIgnoreCase("LOAN")) {
			LoanAccount product=new LoanAccount(productCode,productName,productServicelist);
			return product;
			
		}
		else if(productName.equalsIgnoreCase("Current")) {
			CurrentAccount product=new CurrentAccount(productCode,productName,productServicelist);	
			return product;
		}
		else {
			System.out.println("Product not created. Invalid Product! ");
			return null;
		}
		
		
	}
	
	//display product and services

	public static void displayData(ArrayList<Products> productlist) {
//		ArrayList <Service> tempServicelist=new ArrayList <Service>();
		for(Products products: productlist) {	
			System.out.println("");
			System.out.println("Product Code: "+products.getProductCode()+" "+"Product Name: "+products.getProductName());
			System.out.println("Services:");
//			tempServicelist.addAll(products.getServicetList());
			System.out.println("Service code"+" " +"Service name"+" "+"Service rate");
			for(Service service: products.getServicetList() ) {
				System.out.println(service.getServiceCode()+"\t \t "+service.getServiceName()+"\t \t "+service.getRate());
//				tempServicelist.clear();
			}
		}
		
	}
	
	//create customer and accounts
	public static Customer createCustomer(ArrayList<Products> productlist) {
		ArrayList <Accounts> customerAccountlist=new ArrayList <Accounts>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Customer Code: \n");
		String customerCode=scanner.next();
		System.out.println("Enter Customer Name: \n");
		String customerName=scanner.next();
		customerAccountlist=createAccount(productlist);
		//store customer
		Customer customer=new Customer(customerCode,customerName,customerAccountlist);
		return customer;
	}

	public static ArrayList<Accounts> createAccount(ArrayList<Products> productlist) {
		
		//create account
		ArrayList <Accounts> customerAccountlist=new ArrayList <Accounts>();
		Scanner scanner=new Scanner(System.in);
		int i=1;
		String accountType=null;
		System.out.println("You Can create the following Accounts:");
		for(Products products: productlist) {	
			
			System.out.println("\t "+i+"."+ products.getProductName());
			i++;
		}
		System.out.println("Choose the number:");
		int accountTypeChoice=scanner.nextInt();
		int y=0;
        for(Products products: productlist) {	
			y++;
			if(y==accountTypeChoice) {
				accountType=products.getProductName();
			}
			
					}
		int accountChoice=0; //choice to add more
		while(accountChoice==0) {
			System.out.println("Enter Account No: \n");
			String accountNo=scanner.next();
//			if(accountTypeChoice==1) {
//				accountType="SavingsMax";
//			}
//			else if(accountTypeChoice==2) {
//				accountType="LOAN";
//			}
//			else if(accountTypeChoice==3) {
//				accountType="Current";
//			}
//			else {
//				System.out.println("Invalid input");
//			}
			//balance above 1000
			double balance=0;
			boolean minBal=true;
			while(minBal) {
				System.out.println("Enter Balance: \n");
				balance=scanner.nextInt();
				if(balance<1000) {
					System.out.println("Initial balance needs to be above 1000!");
					
				}
				else {
					minBal=false;
				}
				
			}
			
//			System.out.println("These are the available products");
//			System.out.println("Product Code \t Product Name");
//			for(Products products: productlist) {	
//				System.out.println(products.getProductCode()+"\t "+products.getProductName());
//				
//			}
//			System.out.print("Choose the product code you want to add");
//			String productCode=scanner.next();
			
			for(Products products: productlist) {				
				if(accountType.equalsIgnoreCase(products.getProductName())) {
					//store account
					Accounts accounts=new Accounts(accountNo,accountType,balance,products);
					customerAccountlist.add(accounts);
	        		System.out.println("Added");
				
			}
			
		}
			System.out.println("Enter 0 to create more account/ 1 to exit \n");
			accountChoice=scanner.nextInt();
		    }
		System.out.println("Account Created");
		return customerAccountlist;

}

//Display all accounts
	public static void displayData(Customer customer) {
		System.out.println("Customer Code \t Customer Name  ");
		System.out.println(customer.getCustomerCode()+" "+customer.getCustomerName());
		System.out.println("Account details: ");
		for(Accounts Accounts: customer.getAccountList()) {	
			System.out.println("Account No \t Account Type \t Balance   ");
			System.out.println(Accounts.getAccountNo()+" "+Accounts.getAccountType()+" "+Accounts.getBalance());
			System.out.println("Product details: ");
			System.out.println(Accounts.getProduct());
			
		}
		
		
		
	}
}
