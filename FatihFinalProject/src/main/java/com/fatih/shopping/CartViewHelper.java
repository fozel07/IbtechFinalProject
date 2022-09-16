package com.fatih.shopping;

public class CartViewHelper {
	
	private long productId;
	
	private long cartId;
	
	private String productName;
	
	private double salesQuantity;
	
	private double salesPrice;

	public CartViewHelper(long productId, long cartId, String productName, double salesQuantity, double salesPrice) {
		this.productId = productId;
		this.cartId = cartId;
		this.productName = productName;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
	}
	public CartViewHelper() {
		
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(double salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	
	
	
	

}
