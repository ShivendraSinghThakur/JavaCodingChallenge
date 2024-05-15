package com.java.ECom.main;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.dao.ProductsDao;
import com.java.ECom.dao.ProductsDaoImpl;
import com.java.ECom.model.Products;

public class ShowProductsMain {

	public static void main(String[] args) {
		ProductsDao dao = new ProductsDaoImpl();
		
		try {
			List<Products> productList = dao.showProductsDao();
			for(Products products : productList) {
				System.out.println(products);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
