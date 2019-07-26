package com.kmstore.slowfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.entities.Product;
import com.kmstore.slowfood.repositories.CategoryRepository;
import com.kmstore.slowfood.repositories.DepartmentRepository;
import com.kmstore.slowfood.repositories.ProductRepository;

@Component
public class Initializer implements CommandLineRunner{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("RUNNING INITIALIZER");
		createDepartments();
		createCategories();
		createProducts();
	}

	private void createDepartments() {
		Department produce = new Department("produce");
		deptRepo.save(produce);
		Department meat = new Department("meat");
		deptRepo.save(meat);
		Department seafood = new Department("seafood");
		deptRepo.save(seafood);
		Department deli = new Department("deli");
		deptRepo.save(deli);
		Department cheese = new Department("cheese");
		deptRepo.save(cheese);
		Department dairy = new Department("dairy");
		deptRepo.save(dairy);
		Department bakery = new Department("bakery");
		deptRepo.save(bakery);
		Department frozen = new Department("frozen");
		deptRepo.save(frozen);
		Department packaged = new Department("packaged");
		deptRepo.save(packaged);
	}
	private void createCategories() {
		Category vegetables = new Category("vegetables", deptRepo.findByName("produce"));
		categoryRepo.save(vegetables);
		Category fruits = new Category("fruits", deptRepo.findByName("produce"));
		categoryRepo.save(fruits);
		Category leafyGreens = new Category("leafy-greens", deptRepo.findByName("produce"));
		categoryRepo.save(leafyGreens);
		
		Category pork = new Category("pork", deptRepo.findByName("meat"));
		categoryRepo.save(pork);
		Category beef = new Category("beef", deptRepo.findByName("meat"));
		categoryRepo.save(beef);
		Category poultry = new Category("poultry", deptRepo.findByName("meat"));
		categoryRepo.save(poultry);
		Category dried = new Category("dried", deptRepo.findByName("meat"));
		categoryRepo.save(dried);
	}
	
	private void createProducts() {
		Product driscollsStrawberries = new Product("driscoll's-strawberries", "https://driscolls.imgix.net/-/media/images/pages/finest-berries/strawberries/modal/long-stem.ashx", categoryRepo.findByName("fruit"));
		productRepo.save(driscollsStrawberries);
	}
}
