package com.java.ECom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ECom.model.Orders;
import com.java.ECom.util.DBConnUtil;
import com.java.ECom.util.DBPropertyUtil;

public class OrdersDaoImpl implements OrdersDao{
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		
		String cmd = "select * from Orders where CustomerId = ?";
		
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, custId);
		
		ResultSet rs = pst.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		Orders order = null;
		
		while(rs.next()) {
			order = new Orders();
			order.setCustomerId(rs.getInt("CustomerId"));
			order.setOrderId(rs.getInt("OrderId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setTotalAmount(rs.getDouble("totalAmount"));
			ordersList.add(order);
		}
		return ordersList;
	}

}
