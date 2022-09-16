package com.fatih.shopping;

public class CartProduct {
	private long cartProductId;
	
	private long cartId ;
	
	private long porductId;
	
	private double salesQuantity;
	
	private double salesPrice;

	public CartProduct(long cartProductId, long cartId, long porductId, double salesQuantity, double salesPrice) {
		this.cartProductId = cartProductId;
		this.cartId = cartId;
		this.porductId = porductId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
	}

	public CartProduct( long cartId, long porductId, double salesQuantity, double salesPrice) {
		this.cartId = cartId;
		this.porductId = porductId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
	}
	public CartProduct( ) {
		
	}

	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getPorductId() {
		return porductId;
	}

	public void setPorductId(long porductId) {
		this.porductId = porductId;
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
