package com.kmstore.slowfood.integrationtests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.CategoryRepository;
import com.kmstore.slowfood.repositories.DepartmentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityMappingsTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	Department testDepartment;
	Category testCategory;
	
	@Before
	public void setup() {
		testDepartment = new Department("Department Name");
		departmentRepo.save(testDepartment);
		testCategory = new Category("Category Name", testDepartment);
		categoryRepo.save(testCategory);
		flushAndClearEntityManager();
	}
	
	@Test
	public void shouldSaveAndLoadADepartment() {
		Department retrievedDepartment = departmentRepo.findById(testDepartment.getId()).get();
		assertThat(retrievedDepartment, is(testDepartment));
	}
	
	@Test
	public void shouldSaveAndLoadACategory() {
		Category retrievedCategory = categoryRepo.findById(testCategory.getId()).get();
		assertThat(retrievedCategory, is(testCategory));
	}
	
	

	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}

}
