package com.fatih.authentication.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fatih.authentication.User;
import com.fatih.inventory.Category;
import com.fatih.inventoryManager.BaseManager;

public class UserManager extends BaseManager<User>{
	
	protected User parse(ResultSet resultSet) throws Exception {
		
		long userId = resultSet.getLong("userId");
		String userName = resultSet.getString("userName");
		String userPassword=resultSet.getString("userPassword");
		User user = new User(userId, userName,userPassword);
	
		return user;
	}
	public boolean  insert(User user) throws Exception{
		
		if(findByName(user.getUserName())==null) {
		connect();		
		String sql="insert into users(userName,userPassword) values (?,?)";
	

		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, user.getUserName());
		statement.setString(2, user.getUserPassword());

		int affected = statement.executeUpdate();
		connection .close();
		
		return affected > 0;
		}
		else {
			return false;
		}
							
}
	public User findByName(String userName) throws Exception{
		User user=null;
		connect();
		
		String sql = "SELECT * FROM users WHERE userName=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			user=parse(resultSet);
		}
		disconnect();
		return user;
	}
	public boolean findUserByNameAndPassword(String userName,String userPassword) throws Exception{
		User user=null;
		connect();
		String sql = "SELECT * FROM users WHERE userName=? AND userPassword=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, userPassword);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			user=parse(resultSet);
		}
		
		connection .close();		
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public List<User> listAllUser() throws Exception{
		connect();
		String sql = "SELECT * FROM users";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<User> userList = parseList(resultSet);
		disconnect();
		return userList;
	}
	public User findByUserId(long userId) throws Exception{
		User user=null;
		connect();
		
		String sql = "SELECT * FROM users WHERE userId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, userId);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			user=parse(resultSet);
		}
		disconnect();
		return user;
	}
	
	
	

}
