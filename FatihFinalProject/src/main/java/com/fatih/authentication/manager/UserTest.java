package com.fatih.authentication.manager;

import com.fatih.authentication.User;

public class UserTest {
	public static void main(String[] args) throws Exception {
		UserManager manager=new UserManager();
		manager.insert(new User(2,"Ahmet","123"));
		System.out.println(manager.findUserByNameAndPassword("Ahmet", "123"));
	}

}
