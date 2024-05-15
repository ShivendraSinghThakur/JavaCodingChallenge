package com.java.ECom.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ECom.dao.AuthenticateCustomerDaoImpl;

public class ValidateCustomer {

	public static void main(String[] args) {
		String user, pwd;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName  ");
		user = sc.next();
		System.out.println("Enter Password   ");
		pwd = sc.next();
		AuthenticateCustomerDaoImpl service = new AuthenticateCustomerDaoImpl();
		
		try {
			int count = service.authenticateCustomer(user, pwd);
			if (count==1) {
				System.out.println("Correct Credentials...");
			} else {
				System.out.println("Invalid Credentials...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
