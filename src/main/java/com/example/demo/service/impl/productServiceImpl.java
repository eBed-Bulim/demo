package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.notFoundException;
import com.example.demo.model.product;
import com.example.demo.repository.productRepository;
import com.example.demo.service.productService;

@Service
public class productServiceImpl implements productService {
	
	private productRepository productRepository;
	
	public productServiceImpl(com.example.demo.repository.productRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@Override
	public product saveProduct(product product) {
		return productRepository.save(product);
	}

	@Override
	public List<product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public product getProductById(Integer id) {
				
		return productRepository.findById(id).orElseThrow(()-> new notFoundException("Product", "ID", id));
	}
	
	@Override
	public product updateProduct(product product, Integer id) {
		
		product data = productRepository.findById(id).orElseThrow(()-> new notFoundException("Product", "ID", id));
		data.setCode(product.getCode());
		data.setName(product.getName());
		data.setType(product.getType());
		data.setBrand(product.getBrand());
		data.setDescription(product.getDescription());
		
		productRepository.save(data);
		
		return data;
	}

	@Override
	public void deleteProduct(Integer id) {
		
		productRepository.findById(id).orElseThrow(()-> new notFoundException("Product", "ID", id));
		
		productRepository.deleteById(id);
	}
}
