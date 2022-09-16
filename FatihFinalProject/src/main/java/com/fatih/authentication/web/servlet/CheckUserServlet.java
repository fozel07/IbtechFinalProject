package com.fatih.authentication.web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


import org.xml.sax.SAXException;

import com.fatih.authentication.User;
import com.fatih.authentication.manager.UserManager;
import com.fatih.authentication.xml.UserXml;


@WebServlet("/api/user/check")
public class CheckUserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/xml; charset=UTF-8");
		InputStream in = request.getInputStream();
		User user;
		try {
			user=UserXml.parseUserXml(in);
			UserManager userManager=new UserManager();
			boolean userCheck= userManager.findUserByNameAndPassword(user.getUserName(), user.getUserPassword());
			
			if (userCheck) {
				response.getWriter().write("true");
	            
	            
	            

	        }
	        else {
	        	response.getWriter().write("false");
	            
	        }


			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
