package com.java.ECom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ECom.model.Products;
import com.java.ECom.util.DBConnUtil;
import com.java.ECom.util.DBPropertyUtil;

public class ProductsDaoImpl implements ProductsDao{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Products> showProductsDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		
		String cmd = "select * from Products";
		
		pst = connection.prepareStatement(cmd);
		
		ResultSet rs = pst.executeQuery();
		List<Products> productsList = new ArrayList<Products>();
		Products products = null;
		
		while(rs.next()) {
			products = new Products();
			products.setProductId(rs.getInt("ProductId"));
			products.setProductName(rs.getString("ProductName"));
			products.setDescription(rs.getString("Description"));
			products.setPrice(rs.getDouble("Price"));
			productsList.add(products);
		}
		return productsList;
		
		
	}

	@Override
	public Products searchByProductId(int id) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		
		String cmd = "select * from Products where ProductId = ?";
		
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, id);
		
		ResultSet rs = pst.executeQuery();
		Products products = null;
		
		if(rs.next()) {
			products = new Products();
			products.setProductId(rs.getInt("ProductId"));
			products.setProductName(rs.getString("ProductName"));
			products.setDescription(rs.getString("Description"));
			products.setPrice(rs.getDouble("Price"));
		}
		return products;
	}

	
}
