package com.fatih.authentication.web.client;



import java.io.InputStream;

import com.fatih.core.utils.StreamUtilities;
import com.fatih.core.utils.WebHelper;
import com.fatih.inventory.Category;
import com.fatih.inventory.xml.CategoryXml;

public class UserClient {
	public static void main(String[] args) throws  Exception {
		
		
		
		
	}
	
	public  String  checkUser(String userName,String userPassword) throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/user/check";
		
		
			return 	StreamUtilities.post(address,"<User><userName>"+userName+"</userName><userPassword>"+userPassword+"</userPassword></User>");
	}
	
	public  boolean  createUser(String userName,String userPassword) throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/user/create";
		
		String flag=StreamUtilities.post(address,"<User><userName>"+userName+"</userName><userPassword>"+userPassword+"</userPassword></User>");
		
		if(flag.equals("true")) {
			return true;
		}
		else
			return false;
		 	
	}
	
	

}
