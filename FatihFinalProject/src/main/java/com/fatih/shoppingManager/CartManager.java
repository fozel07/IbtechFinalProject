package com.fatih.shoppingManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fatih.inventory.Category;
import com.fatih.inventory.Product;
import com.fatih.inventoryManager.BaseManager;
import com.fatih.shopping.Cart;

public class CartManager extends BaseManager<Cart> {
	public Cart find(long cartid) throws Exception{
		Cart cart=null;
		connect();
		
		String sql = "SELECT * FROM Cart WHERE cartid=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartid);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			cart=parse(resultSet);
		}
		disconnect();
		return cart;
	}
	
	
	public List<Cart> list() throws Exception{
		connect();
		String sql = "SELECT * FROM cart";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Cart> carttList = parseList(resultSet);
		disconnect();
		return carttList;
	}

	
	protected Cart parse(ResultSet resultSet) throws Exception {
		
		long cartId = resultSet.getLong("cartId");
		double totalAmount = resultSet.getDouble("totalAmount");
		String customerName  = resultSet.getString("customerName");
		
		
		Cart cart = new Cart(cartId, totalAmount, customerName);
	
		return cart;
	}
	public Cart insert(Cart cart) throws Exception {
		connect();
		String sql = "INSERT INTO cart(totalamount,customername) VALUES(?,?)";

		PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setDouble(1,cart.getTotalAmount());
		statement.setString(2,cart.getCustomerName());
		int affected = statement.executeUpdate();
		if (affected == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			cart.setCartId(generatedKeys.getLong(1));
	     }
		
         
		
		disconnect();

		return cart;

	}
	public boolean update(Cart cart) throws Exception {
		
		connect();
		String sql = "UPDATE cart SET totalAmount=? WHERE cartId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, (cart.getTotalAmount()));
		statement.setLong(2, cart.getCartId());
		

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}
	public boolean deleteCart(long cartId) throws Exception {
		connect();

		String sql = "DELETE FROM Cart WHERE cartId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartId);

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}
	
	

}
