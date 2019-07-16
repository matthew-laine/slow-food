package com.kmstore.slowfood.integrationtests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.DepartmentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityMappingsTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Test
	public void shouldSaveAndLoadADepartment() {
		Department testDepartment = new Department("Department Name");
		departmentRepo.save(testDepartment);
		flushAndClearEntityManager();
		Department retrievedDepartment = departmentRepo.findById(testDepartment.getId()).get();
		assertThat(retrievedDepartment, is(testDepartment));
	}

	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}

}
