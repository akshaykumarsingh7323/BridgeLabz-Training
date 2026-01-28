package com.binarysearchtree.ecommerceproductinventry;

public class ProductNode {
	Product product;
	ProductNode left;
	ProductNode right;
	public Product getProduct() {
		return product;
	}
	public ProductNode(Product product) {
		this.product = product;
	}
}
