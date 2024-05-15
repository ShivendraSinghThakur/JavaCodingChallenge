package com.java.ECom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ECom.model.Customers;
import com.java.ECom.util.DBConnUtil;
import com.java.ECom.util.DBPropertyUtil;

public class CustomersDaoImpl implements CustomerDao {
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Customers> showCustomerDao() throws ClassNotFoundException, SQLException {
		
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		
		String cmd = "select * from Customers";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		
		List<Customers> customerList = new ArrayList<Customers>();
		Customers customer = null;
		
		while(rs.next()) {
			customer = new Customers();
			customer.setCustomerId(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("LastName"));
			customer.setEmail(rs.getString("Email"));
			//customer.setPhone(rs.getString("Phone"));
			customer.setAddress(rs.getString("address"));
			customerList.add(customer);
		}
		return customerList;
	}

	@Override
	public Customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Customers where CustomerId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, custId);
		ResultSet rs = pst.executeQuery();
		Customers customer = null;
		
		if(rs.next()) {
			customer = new Customers();
			customer.setCustomerId(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));
			//customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
		}
		return customer;
	}

	@Override
	public Customers searchByEmail(String email) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Customers where Email = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		Customers customer = null;
		
		if(rs.next()) {
			customer = new Customers();
			customer.setCustomerId(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("lastName"));
			customer.setEmail(rs.getString("email"));
			//customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
		}
		return customer;
	}

	
}
