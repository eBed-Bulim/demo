package com.example.demo.service;

import java.util.List;

import com.example.demo.model.product;

public interface productService {
	product saveProduct(product product);
	
	List<product> getAllProduct();
	
	product getProductById(Integer id);
	
	product updateProduct(product product, Integer id);
	
	void deleteProduct(Integer id);
}
