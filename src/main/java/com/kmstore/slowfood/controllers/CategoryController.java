package com.kmstore.slowfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.repositories.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@GetMapping("/categories")
	public Iterable<Category> retrieveAllCategories(){
		return categoryRepo.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public Category retrieveCategory(@PathVariable Long id) {
		return categoryRepo.findById(id).get();
	}
	
	@PostMapping
	public Iterable<Category> postSingleCategory(@PathVariable Category category){
		categoryRepo.save(category);
		return categoryRepo.findAll();
	}
}
