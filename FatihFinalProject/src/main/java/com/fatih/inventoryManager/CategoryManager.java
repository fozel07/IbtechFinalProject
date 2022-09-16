package com.fatih.inventoryManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fatih.inventory.Category;
import com.fatih.inventory.Product;



public class CategoryManager extends BaseManager<Category> {
	
	
	public List<Category> list() throws Exception{
		connect();
		String sql = "SELECT * FROM category";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Category> productList = parseList(resultSet);
		disconnect();
		return productList;
	}

	
	protected Category parse(ResultSet resultSet) throws Exception {
		
		long categoryId = resultSet.getLong("categoryId");
		String categoryName = resultSet.getString("categoryName");
		Category category = new Category(categoryId, categoryName);
	
		return category;
	}
	public boolean  insert(Category category) throws Exception{
		
		if(findByName(category.getCategoryName())==null) {
		connect();		
		String sql="insert into Category(categoryName) values (?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, category.getCategoryName());

		int affected = statement.executeUpdate();
		connection .close();
		
		return affected > 0;
		}
		else {
			return false;
		}
							
}
	public Category findByName(String categoryName) throws Exception{
		Category category=null;
		connect();
		
		String sql = "SELECT * FROM category WHERE categoryName=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, categoryName);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			category=parse(resultSet);
		}
		disconnect();
		return category;
	}
	public boolean delete(long categoryId) throws Exception{
	
		connect();
		String sqlCategory="delete from category where categoryId=?";
		PreparedStatement statement=connection.prepareStatement(sqlCategory);
		statement.setLong(1, categoryId);
		String sqlProduct="delete from product where categoryId=?";
		PreparedStatement statementProduct=connection.prepareStatement(sqlProduct);
		statementProduct.setLong(1, categoryId);
		statementProduct.executeUpdate();
		
		int affected = statement.executeUpdate();
		connection .close();
		return affected > 0;
	}
	public Category find(long categoryId) throws Exception{
		Category category=null;
		connect();
		
		String sql = "SELECT * FROM Category WHERE categoryId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, categoryId);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			category=parse(resultSet);
		}
		disconnect();
		return category;
	}
	
	
	

	
}
