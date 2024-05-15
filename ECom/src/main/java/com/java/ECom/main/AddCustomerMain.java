package com.java.ECom.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ECom.dao.AuthenticateCustomerDaoImpl;
import com.java.ECom.model.Customers;

public class AddCustomerMain {

	public static void main(String[] args) {
		Customers customer = new Customers();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id");
		customer.setCustomerId(sc.nextInt());
		System.out.println("Enter FirstName  ");
		customer.setFirstName(sc.next());
		System.out.println("Enter LastName  ");
		customer.setLastName(sc.next());
		System.out.println("Enter Email  ");
		customer.setEmail(sc.next());
		//System.out.println("Enter Phone No  ");
		//customer.setPhoneNumber(sc.next());
		System.out.println("Enter Address  ");
		customer.setAddress(sc.next());
		//System.out.println("Enter UserName  ");
		//customer.setUserName(sc.next());
		customer.setPassWord(sc.next());
		AuthenticateCustomerDaoImpl service = new AuthenticateCustomerDaoImpl();
		
		try {
			System.out.println(service.addCustomer(customer));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
