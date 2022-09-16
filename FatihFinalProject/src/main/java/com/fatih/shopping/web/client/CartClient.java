package com.fatih.shopping.web.client;

import java.io.InputStream;
import java.util.List;

import com.fatih.core.utils.StreamUtilities;
import com.fatih.core.utils.WebHelper;
import com.fatih.inventory.Category;
import com.fatih.inventory.xml.CategoryXml;
import com.fatih.shopping.Cart;
import com.fatih.shopping.xml.CartXml;

public class CartClient {
	
	public Cart  createCart(double amount,String customerName) throws Exception {
		
		String address=String.format("http://localhost:8081/FatihFinalProject/api/cart/create?customerName=%s&totalAmount=%d",customerName,(long)amount);
		
		InputStream in=WebHelper.get(address);

		Cart cart=CartXml.parseCartXml(in);
		
		return cart;				
	}
public void   updateCart(Cart cart) throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/cart/update";
		String cartId=Long.toString(cart.getCartId());
		String totalAmount=Double.toString(cart.getTotalAmount());
		String userName=cart.getCustomerName();
		 cartId = "\"" + cartId + "\"";
		String postXml="<Cart id="+cartId+"><totalAmount>"+totalAmount+"</totalAmount><customerName>"+userName+"</customerName></Cart>";
		StreamUtilities.post(address,postXml);
		
		
						
	}
}
	
	
	


