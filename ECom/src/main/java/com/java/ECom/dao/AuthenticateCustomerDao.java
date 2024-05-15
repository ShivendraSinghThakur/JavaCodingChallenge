package com.java.ECom.dao;

import java.sql.SQLException;

import com.java.ECom.model.Customers;

public interface AuthenticateCustomerDao {

	String addCustomer(Customers customer) throws ClassNotFoundException, SQLException;
	int authenticateCustomer(String user, String pwd) throws ClassNotFoundException, SQLException;
}
