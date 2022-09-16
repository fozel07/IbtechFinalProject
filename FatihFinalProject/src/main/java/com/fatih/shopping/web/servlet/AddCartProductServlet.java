package com.fatih.shopping.web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;
import com.fatih.shopping.xml.CartProductXml;
import com.fatih.shopping.xml.CartXml;
import com.fatih.shoppingManager.CartManager;
import com.fatih.shoppingManager.CartProductManager;

@WebServlet("/api/cart/addProduct")
public class AddCartProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/xml; charset=UTF-8");
		InputStream in = request.getInputStream();
		CartProduct cartProduct;
		try {
			cartProduct=CartProductXml.parseCartProductXml(in);
			CartProductManager cartProductManager=new CartProductManager();
			cartProductManager.insert(cartProduct);
			
			
			
			
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 }

}
