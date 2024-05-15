package com.java.ECom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.model.Customers;

public interface CustomerDao {

	List<Customers> showCustomerDao() throws ClassNotFoundException, SQLException;
	Customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException;
	Customers searchByEmail(String email) throws ClassNotFoundException, SQLException;
	
}
