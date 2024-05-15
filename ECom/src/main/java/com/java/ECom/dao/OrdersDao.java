package com.java.ECom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.model.Orders;

public interface OrdersDao {

	List<Orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException;

	String PlaceOrder(int Cust_Id, int Product_Id, int QuantityOrd) throws ClassNotFoundException, SQLException;

	int generateOrderId() throws ClassNotFoundException, SQLException;
}
}
