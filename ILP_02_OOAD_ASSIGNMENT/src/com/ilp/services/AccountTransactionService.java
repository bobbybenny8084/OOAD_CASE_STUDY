package com.ilp.services;

import java.util.Scanner;

import com.ilp.entity.Accounts;
import com.ilp.entity.Customer;

public class AccountTransactionService {

	//Deposit money
	public static void depositMoney(Customer customer) {
		Scanner scanner=new Scanner(System.in);
		System.out.println(customer.getCustomerName()+" please enter the account number you want to deposit money");
		System.out.println("Available account: ");
		for(Accounts accounts: customer.getAccountList()) {	
			System.out.println("Account No \t Account Type \t Balance   ");
			System.out.println(accounts.getAccountNo()+" "+accounts.getAccountType()+" "+accounts.getBalance());
			System.out.println("Product details: ");
			System.out.println(accounts.getProduct());
			
		}
		
		String accNo=scanner.next();
		for(Accounts accounts: customer.getAccountList()) {
			if(accNo.equalsIgnoreCase(accounts.getAccountNo())) {
				double newBalance;
				double currentBalance=accounts.getBalance();
				System.out.println("Enter the amount you want to deposit: ");
				double addingMoney=scanner.nextInt();
				//check if loan Acc
				if(accounts.getAccountType().equalsIgnoreCase("LOAN")) {
					System.out.println("Enter 1 for Cash deposit | Enter 2 for cheque deposit ");
					int loanDepositChoice=scanner.nextInt();
					
					//cases for cheque and cash deposit 
					switch(loanDepositChoice) {
					case 1:
						newBalance=addingMoney+currentBalance;
						accounts.setBalance(newBalance);
						System.out.println((char)27 + "[31m" +"Deposited successfully, New balance is: "+newBalance +"\u001B[30m");
						break;
						
					case 2:
						System.out.println("for cheque deposit 0.3% of depositing amount will be charged: ");
						addingMoney=addingMoney-(addingMoney*0.3);
						newBalance=addingMoney+currentBalance;
						accounts.setBalance(newBalance);
						System.out.println((char)27 + "[31m" +"Deposited successfully, New balance is: "+newBalance +"\u001B[30m");
						break;
					
					}
					
					
				}
				else {
					newBalance=addingMoney+currentBalance;
					accounts.setBalance(newBalance);
					System.out.println((char)27 + "[31m" +"Deposited successfully, New balance is: "+newBalance +"\u001B[30m");
				}
				
			} //main if closed
		} //main for loop closed
		
	}
	
    //function to withdraw money
	public static void withdrawMoney(Customer customer) {
		Scanner scanner=new Scanner(System.in);
		double newBalance;
		System.out.println(customer.getCustomerName()+" please enter the account number you want to withdraw money from:");
		System.out.println("Available account: ");
		//Display accounts
		for(Accounts accounts: customer.getAccountList()) {	
			System.out.println("Account No \t Account Type \t Balance   ");
			System.out.println(accounts.getAccountNo()+" "+accounts.getAccountType()+" "+accounts.getBalance());
//			System.out.println("Product details: ");
//			System.out.println(accounts.getProduct());
			
		}
		
		String accNo=scanner.next();
		//check if correct acc no is entered.
		for(Accounts accounts: customer.getAccountList()) {
			if(accNo.equalsIgnoreCase(accounts.getAccountNo())) {
				double currentBalance=accounts.getBalance(); //current balance
	//loan acc			
				if(accounts.getAccountType().equalsIgnoreCase("LOAN")) {
					System.out.println((char)27 + "[31m" +"This is a LOAN account! You cannot withdraw from this account!"+"\u001B[30m");
				}
	//SavingsMax acc			
				else if(accounts.getAccountType().equalsIgnoreCase("SavingsMax")){
					System.out.println("Current balance is:"+currentBalance+"  Enter the amount you want to withdraw: ");
					double withdrawMoney=scanner.nextInt();
					if(currentBalance-withdrawMoney<1000) {
						System.out.println((char)27 + "[31m" +"Transaction Failed! The minimum balance needs to 1000. Try a Lower Amount "+"\u001B[30m");
					}
					else {
						newBalance=currentBalance-withdrawMoney;
						accounts.setBalance(newBalance);
						System.out.println((char)27 + "[31m" +"Transaction successful, New balance is: "+newBalance +"\u001B[30m");	
						
					}	
				}
	//all other acc			
				else {
					System.out.println("Current balance is:"+currentBalance+"  Enter the amount you want to withdraw: ");
					double withdrawMoney=scanner.nextInt();
					if(currentBalance-withdrawMoney<0) {
						System.out.println((char)27 + "[31m" +"Transaction Failed! The balance cannot be lower than 0. Try a Lower Amount "+"\u001B[30m");
					}
					else {
						newBalance=currentBalance-withdrawMoney;
						accounts.setBalance(newBalance);
						System.out.println((char)27 + "[31m" +"Transaction successful, New balance is: "+newBalance +"\u001B[30m");	
						
					}	
					
				}
				
				
			} //account if closed
			
		} //main for loop
	}

	public static void showBalance(Customer customer) {
		System.out.println("Available account: ");
		//Display accounts
		for(Accounts accounts: customer.getAccountList()) {	
			System.out.println("Account No \t Account Type \t Balance   ");
			System.out.println(accounts.getAccountNo()+" "+accounts.getAccountType()+" "+accounts.getBalance());
			
		}
		
		
	}

}
