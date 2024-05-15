package com.java.ECom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.model.Products;

public interface ProductsDao {
	
	List<Products> showProductsDao() throws ClassNotFoundException, SQLException;
	Products searchByProductId(int id) throws ClassNotFoundException, SQLException;
}
