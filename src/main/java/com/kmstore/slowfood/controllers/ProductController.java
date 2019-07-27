package com.kmstore.slowfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmstore.slowfood.entities.Product;
import com.kmstore.slowfood.repositories.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/products")
	public Iterable<Product> retrieveAllProducts(){
		return productRepo.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product retrieveProduct(@PathVariable Long id) {
		return productRepo.findById(id).get();
	}

	@PostMapping("/products")
	public Iterable<Product> postSingleProduct(@RequestBody Product product) {
		productRepo.save(product);
		return productRepo.findAll();
	}
}
