package com.demo.model;

public class Product {
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + "]";
	}
	public Product(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	String productId;
	String productName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}
