package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Accounts;
import com.ilp.entity.Customer;
import com.ilp.entity.Products;
import com.ilp.entity.Service;
import com.ilp.services.AccountServices;
import com.ilp.services.AccountTransactionService;

public class AccountUtility {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList <Service> servicelist=new ArrayList <Service>();
		ArrayList <Products> productlist=new ArrayList <Products>();
		ArrayList <Accounts> customerAccountlist=new ArrayList <Accounts>();
		Customer customer=null;
		System.out.println("\u001B[31m" +"***********WELCOME TO BANK***********"+"\u001B[30m" );
		int response=0;
		while(response==0) {
			System.out.println("Choose from the below menu:");
			System.out.println("\u001B[34m" +"1.CREATE SERVICE  \t 2.CREATE PRODUCTS \t 3.DISPLAY PRODUCTS \t 4.CREATE ACCOUNT \t 5.VIEW ACCOUNTS \t 6.MANAGE ACCOUNT \t 7.EXIT" +"\u001B[30m");
			int mainChoice=scanner.nextInt();
			switch(mainChoice) {
			case 1:
				System.out.println("Enter Details");
				servicelist.add(AccountServices.createService());
				break;
			case 2:
				System.out.println("Enter Product details");
				productlist.add(AccountServices.createProduct(servicelist));
				break;
			case 3:
				System.out.println("Available Products:");
				AccountServices.displayData(productlist);
				
				break;
			case 4:
				if(customer==null) {
					System.out.println("Enter Customer details");
					customer=AccountServices.createCustomer(productlist);
					break;				
				}
				else {
					System.out.println("Enter Account details");
					customerAccountlist=AccountServices.createAccount(productlist);
					customer.setAccountList(customerAccountlist);
					break;
				}
				
			case 5:
				System.out.println("These are your Account details:");
				AccountServices.displayData(customer);
				break;
			
			case 6:
				System.out.println("1.Deposit Money  \t 2.Withdraw Money \t 3.Display Balance ");
				int accountChoice=scanner.nextInt();
				switch(accountChoice) {
				case 1:
					AccountTransactionService.depositMoney(customer);
					break;
				case 2:
					AccountTransactionService.withdrawMoney(customer);
					break;
				case 3:
					AccountTransactionService.showBalance(customer);
					break;
				default:
					System.out.println((char)27 + "[31m" +"Oh! Invalid Input ;( "+"\u001B[30m");
					break;
				}
				break;
				
			case 7:
				System.out.println((char)27 + "[31m" +"**************Thanks for coming to BANK**************"+"\u001B[30m");
				return ;
			default:
				System.out.println((char)27 + "[31m" +"Invalid Input"+"\u001B[30m");
				break;
			
			}
			System.out.println("Enter 0 to go back to main  menu:");
			response=scanner.nextInt();		
			}
	}

}
