package com.kmstore.slowfood.controllertests.weblayer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.DepartmentRepository;
import com.wcci.albumcollection.entities.Artist;

@WebMvcTest(DepartmentController.class)
@RunWith(SpringRunner.class)
public class DepartmentControllerWebLayerTest {
		
		@Autowired
		MockMvc mockMvc;
		
		@MockBean
		DepartmentRepository departmentRepo;
		
		private Department department;
		
		private ObjectMapper mapper = new ObjectMapper();
		
		@Before
		public void setup() {
			department = new Department("Department Name");
		}
		
		@Test
		public void fetchCollectionOfDepartments() throws Exception {
			when(departmentRepo.findAll()).thenReturn(Collections.singletonList(department));
			mockMvc.perform(get("/api/departments")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().json("[{}]"))
			.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(department)), true));;
		}

}
