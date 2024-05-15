package com.java.ECom.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ECom.model.Orders;
import com.java.ECom.model.Products;

public class PlaceOrderMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter customer_id");
		int cid = sc.nextInt();
		System.out.println("Enter product_id");
		int pid = sc.nextInt();
		System.out.println("Enter quantity");
		int q = sc.nextInt();
		Products p=new Products();
		
		try {
			boolean flag=p.available(q, pid);
			if(!flag) {
				System.out.println("Out of stock");
			}
			else {
				Orders o=new Orders();
				System.out.println(o.PlaceOrder(cid, pid, q));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
