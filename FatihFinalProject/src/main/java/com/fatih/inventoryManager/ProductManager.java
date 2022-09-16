package com.fatih.inventoryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fatih.inventory.Product;




public class ProductManager extends BaseManager<Product> {
	
	public Product find(long productId) throws Exception{
		Product product=null;
		connect();
		
		String sql = "SELECT * FROM product WHERE productId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			product=parse(resultSet);
		}
		disconnect();
		return product;
	}
	
	
	public List<Product> list() throws Exception{
		connect();
		String sql = "SELECT * FROM product";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		disconnect();
		return productList;
	}

	
	protected Product parse(ResultSet resultSet) throws Exception {
		
		long productId = resultSet.getLong("productId");
		String productName = resultSet.getString("productName");
		double salesPrice  = resultSet.getDouble("salesPrice");
		long categoryId   = resultSet.getLong("categoryId");
		String imagePath  = resultSet.getString("imagePath");
		
		Product product = new Product(productId, productName, salesPrice,categoryId,imagePath);
	
		return product;
	}
	public List<Product> findProductByProductId(long productId) throws Exception{
		connect();
		String sql = "SELECT * FROM product WHERE productId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		disconnect();
		return productList;
	}
	public List<Product> findProductByCategory(long categoryId) throws Exception{
		connect();
		String sql = "SELECT * FROM product WHERE categoryId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, categoryId);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		disconnect();
		return productList;
	}
	
	

}
