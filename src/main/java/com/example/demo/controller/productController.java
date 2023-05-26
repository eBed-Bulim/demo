package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.product;
import com.example.demo.service.productService;

@RestController
@RequestMapping("/api/products")
public class productController {
	
	private productService productService;

	public productController(com.example.demo.service.productService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<product> saveProduct(@RequestBody product product){
		return new ResponseEntity<product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<product> getProductById(@PathVariable("id") Integer id){
		return new ResponseEntity<product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<product> updateProduct(@PathVariable("id") Integer id, @RequestBody product product){
		return new ResponseEntity<product>(productService.updateProduct(product, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
		productService.deleteProduct(id);
		
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}
}
