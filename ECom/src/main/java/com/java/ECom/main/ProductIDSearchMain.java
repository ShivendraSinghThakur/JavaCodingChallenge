package com.java.ECom.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.ECom.dao.ProductsDao;
import com.java.ECom.dao.ProductsDaoImpl;
import com.java.ECom.model.Products;

public class ProductIDSearchMain {

	public static void main(String[] args) {
		int productId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Id  ");
		productId = sc.nextInt();
		ProductsDao dao = new ProductsDaoImpl();
		
		try {
			Products product = dao.searchByProductId(productId);
			if (product != null) {
				System.out.println(product);
			} else {
				System.out.println("*** Product Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
