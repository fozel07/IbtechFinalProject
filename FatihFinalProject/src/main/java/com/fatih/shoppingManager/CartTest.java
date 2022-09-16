package com.fatih.shoppingManager;

import java.util.List;

import com.fatih.shopping.Cart;
import com.fatih.shopping.CartProduct;

public class CartTest {
	public static void main(String[] args) throws Exception {

		
		CartProductManager cartProductManager=new CartProductManager();
		
		List<CartProduct> list = cartProductManager.listByCartId(42);
		
		
		
		
		

	}
}
