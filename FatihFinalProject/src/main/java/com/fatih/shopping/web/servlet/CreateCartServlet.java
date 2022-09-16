package com.fatih.shopping.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.fatih.core.utils.XmlHelper;
import com.fatih.inventory.Category;
import com.fatih.inventory.xml.CategoryXml;
import com.fatih.inventoryManager.CategoryManager;
import com.fatih.shopping.Cart;
import com.fatih.shopping.xml.CartXml;
import com.fatih.shoppingManager.CartManager;

@WebServlet("/api/cart/create")
public class CreateCartServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("customerName")!=null) {
			String customerName  = request.getParameter("customerName");
			double totalAmount  = Double.parseDouble(request.getParameter("totalAmount"));
			
		CartManager cartManager = new CartManager();
		Cart cart=new Cart(totalAmount,customerName);
		try {
			
			Document document = CartXml.format(cartManager.insert(cart));
			response.setContentType("application/xml; charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
 }
}
