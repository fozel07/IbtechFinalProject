package com.fatih.shoppingManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fatih.inventoryManager.BaseManager;
import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;

public class CartProductManager extends BaseManager<CartProduct>{
	public CartProduct findByProductIdAndCartId(long productId,long cartId) throws Exception{
		CartProduct cartProduct=null;
		connect();
		
		String sql = "SELECT * FROM CartProduct WHERE productId=? and cartId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		statement.setLong(2, cartId);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			cartProduct=parse(resultSet);
		}
		disconnect();
		return cartProduct;
	}
	public List<CartProduct> listByCartId(long cartId) throws Exception{
		connect();
		String sql = "SELECT * FROM CartProduct WHERE cartId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartId);
		ResultSet resultSet = statement.executeQuery();
		List<CartProduct> cartProductList = parseList(resultSet);
		disconnect();
		return cartProductList;
	}
	
	
	public List<CartProduct> list() throws Exception{
		connect();
		String sql = "SELECT * FROM CartProduct";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<CartProduct> cartProductList = parseList(resultSet);
		disconnect();
		return cartProductList;
	}

	
	protected CartProduct parse(ResultSet resultSet) throws Exception {
		
		long cartProductId = resultSet.getLong("cartProductId");
		long cartId = resultSet.getLong("cartId");
		long productId = resultSet.getLong("productId");
		double salesQuantity = resultSet.getDouble("salesQuantity");
		double salesPrice  = resultSet.getDouble("salesPrice");
		
		
		CartProduct cartProduct = new CartProduct(cartProductId, cartId, productId,salesQuantity,salesPrice);
	
		return cartProduct;
	}
	public CartProduct insert(CartProduct cartProduct) throws Exception {
		connect();
		String sql = "INSERT INTO CartProduct(cartId,productId,salesQuantity,salesPrice) VALUES(?,?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setLong(1,cartProduct.getCartId());
		statement.setLong(2,cartProduct.getPorductId());
		statement.setDouble(3,cartProduct.getSalesQuantity());
		statement.setDouble(4,cartProduct.getSalesPrice());
		int affected = statement.executeUpdate();
		if (affected == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			cartProduct.setCartId(generatedKeys.getLong(1));
	     }
		
         
		
		disconnect();

		return cartProduct;

	}
	public boolean delete(long cartProductId) throws Exception {
		connect();

		String sql = "DELETE FROM CartProduct WHERE cartProductId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, cartProductId);

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}
public boolean update(CartProduct cartProduct) throws Exception {
		
		connect();
		String sql = "UPDATE CartProduct SET salesQuantity=? WHERE cartProductId=?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, (cartProduct.getSalesQuantity()+1));
		statement.setLong(2, cartProduct.getCartProductId());

		

		int affected = statement.executeUpdate();
		disconnect();

		return affected > 0;
	}
	
}
