package com.kmstore.slowfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.DepartmentRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentRepository deptRepo;
	
	@GetMapping("/departments")
	public Iterable<Department> retrieveAllDepartments(){
		return deptRepo.findAll();
	}
	
	@GetMapping("/departments/{id}")
	public Department retrieveDepartment(@PathVariable Long id) {
		return deptRepo.findById(id).get();
	}

	@PostMapping("/departments")
	public Iterable<Department> postSingleDepartment(@RequestBody Department dept) {
		deptRepo.save(dept);
		return deptRepo.findAll();
	}
}
