package com.java.ECom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ECom.model.Orders;

public interface OrdersDao {

	List<Orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException;
}
