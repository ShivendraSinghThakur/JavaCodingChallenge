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

	@Override
	public String PlaceOrder(int Cust_Id, int Product_Id, int QuantityOrd) throws ClassNotFoundException, SQLException {
		Carts c= new Carts();
		int cid=c.generateCartId();
		int oid=generateOrderId();
		OrderItem o=new OrderItem();
		int orid=o.generateOrderItemId();
		
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		
		String cmd="insert into cart(cart_id,customer_id,product_id,quantity) values(?,?,?,?) ";
		
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, cid);
		pst.setInt(2, Cust_Id);
		pst.setInt(3,Product_Id);
		pst.setInt(4, QuantityOrd);
		pst.executeUpdate();
		
		String am="select price from products where product_id=?";
		pst=connection.prepareStatement(am);
		pst.setInt(1,Product_Id);
		ResultSet rs= pst.executeQuery();
		rs.next();
		double item_amount=rs.getDouble("price")*QuantityOrd;
		
		
		String add="select address from customers where customer_id=?";
		pst=connection.prepareStatement(add);
		pst.setInt(1, Cust_Id);
		ResultSet rs1=pst.executeQuery();
		rs1.next();
		String ad=rs1.getString("address");
		
		String price="select o.order_id,sum(oi.item_amount) total_price \r\n"
				+ "from orders o inner join order_items oi\r\n"
				+ "on o.order_id = oi.order_id \r\n"
				+ "group by  o.order_id ";
		pst=connection.prepareStatement(price);
//		pst.setInt(1, oid);
//		pst.setDouble(2, item_amount);
//		pst.setInt(3, oid);
//		pst.setInt(4, orid);
//		pst.setInt(5, oid);
		ResultSet rs2=pst.executeQuery();
		rs2.next();
		double total_price=rs2.getDouble("total_price");
		
		String cmd2="insert into orders(order_id,customer_id,order_date,total_price,shipping_address) values(?,?,?,?,?) ";
		pst=connection.prepareStatement(cmd2);
		pst.setInt(1, oid);
		pst.setInt(2, Cust_Id);
		pst.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
		pst.setDouble(4,total_price);
		pst.setString(5, ad);
		pst.executeUpdate();
		
		String cmd1="insert into order_items(order_item_id,order_id,product_id,quantity,item_amount) values (?,?,?,?,?)";
		pst=connection.prepareStatement(cmd1);
		pst.setInt(1, orid);
		pst.setInt(2, oid);
		pst.setInt(3,Product_Id);
		pst.setInt(4, QuantityOrd);
		pst.setDouble(5,item_amount );
		pst.executeUpdate();
		return "order placed.....";
	}

	@Override
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd="Select max(order_id)+1 oid from orders";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int oid=rs.getInt("oid");
		return oid;
	}

}
