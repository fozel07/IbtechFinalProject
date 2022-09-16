package com.fatih.shopping.web.client;

import java.io.InputStream;
import java.util.List;

import com.fatih.core.utils.WebHelper;
import com.fatih.inventory.Product;
import com.fatih.inventory.xml.CartViewHelperXml;
import com.fatih.inventory.xml.ProductXml;
import com.fatih.shopping.CartViewHelper;

public class CartViewClient {
	
public   List<CartViewHelper>  cartViewByCartId(long cartId) throws Exception {
		
		String address=String.format("http://localhost:8081/FatihFinalProject/api/cart/view?cartId=%d", cartId);
		
		InputStream in=WebHelper.get(address);
	
		List<CartViewHelper> productList=CartViewHelperXml.parseProductViewXmlList(in);
		
		return productList;				
	}


public   void deleteFromCart(long cartId,long productId) throws Exception {
	
	String address=String.format("http://localhost:8081/FatihFinalProject/api/cart/remove?cartid=%d&productid=%d", cartId,productId);
	
	WebHelper.get(address);

	
				
}



}
