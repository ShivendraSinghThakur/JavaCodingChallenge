package com.java.ECom.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ECom.dao.CustomerDao;
import com.java.ECom.dao.CustomersDaoImpl;
import com.java.ECom.model.Customers;

public class CustomerIdSearchMain {

	public static void main(String[] args) {
		int custId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id  ");
		custId = sc.nextInt();
		CustomerDao dao = new CustomersDaoImpl();
		
		try {
			Customers customer = dao.searchByCustomerId(custId);
			if (customer !=null) {
				System.out.println(customer);
			} else {
				System.out.println("*** Customer Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
