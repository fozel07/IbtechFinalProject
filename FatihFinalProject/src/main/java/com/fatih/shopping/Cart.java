package com.fatih.shopping;

public class Cart {
	
	private long cartId;
	
	private double totalAmount;
	
	private String customerName;

	public Cart(long cartId, double totalAmount, String customerName) {
		this.cartId = cartId;
		this.totalAmount = totalAmount;
		this.customerName = customerName;
	}
	public Cart( double totalAmount, String customerName) {
		this.totalAmount = totalAmount;
		this.customerName = customerName;
	}
	public Cart() {
		
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	

}
