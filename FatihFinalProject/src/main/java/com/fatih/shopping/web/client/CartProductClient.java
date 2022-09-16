package com.fatih.shopping.web.client;

import com.fatih.core.utils.StreamUtilities;
import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;

public class CartProductClient {
	
public void   addCart(CartProduct cartProduct) throws Exception {
		
		String address="http://localhost:8081/FatihFinalProject/api/cart/addProduct";
		String cartId=Long.toString(cartProduct.getCartId());
		String productId=Long.toString(cartProduct.getPorductId());
		String salesQuantity=Double.toString(cartProduct.getSalesQuantity());
		String salesPrice=Double.toString(cartProduct.getSalesPrice());
		String postXml="<CartProduct><cartId>"+cartId+"</cartId><productId>"+productId+"</productId><salesQuantity>"+salesQuantity+"</salesQuantity><salesPrice>"+salesPrice+"</salesPrice></CartProduct>";
		StreamUtilities.post(address,postXml);
						
	}

}
