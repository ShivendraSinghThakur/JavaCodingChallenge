package com.java.ECom.main;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.dao.CustomerDao;
import com.java.ECom.dao.CustomersDaoImpl;
import com.java.ECom.model.Customers;

public class CustomerShowMain {

	public static void main(String[] args) {
		CustomerDao dao = new CustomersDaoImpl();
		
		try {
			List<Customers> customerList = dao.showCustomerDao();
			for(Customers customers : customerList) {
				System.out.println(customers);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
