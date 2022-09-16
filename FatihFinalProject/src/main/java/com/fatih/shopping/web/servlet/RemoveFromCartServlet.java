package com.fatih.shopping.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.fatih.core.utils.XmlHelper;
import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;
import com.fatih.shopping.xml.CartXml;
import com.fatih.shoppingManager.CartManager;
import com.fatih.shoppingManager.CartProductManager;

@WebServlet("/api/cart/remove")
public class RemoveFromCartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("cartid")!=null && request.getParameter("productid")!=null) {
		
		try {
			
			long cartId  = Long.parseLong(request.getParameter("cartid"));
			long ProductId  = Long.parseLong(request.getParameter("productid"));
			
		CartProductManager cartProductManager = new CartProductManager();
		CartProduct cartProduct=cartProductManager.findByProductIdAndCartId(ProductId, cartId);
		cartProductManager.delete(cartProduct.getCartProductId());
		
		CartManager cartManager=new CartManager();
		double sum =cartManager.find(cartId).getTotalAmount()-(cartProduct.getSalesPrice()*cartProduct.getSalesQuantity());

		cartManager.update(new Cart(cartProduct.getCartId(),sum,"123"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
 }

}
