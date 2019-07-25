package com.kmstore.slowfood.controllertests.weblayer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmstore.slowfood.controllers.CategoryController;
import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.CategoryRepository;

@WebMvcTest(CategoryController.class)
@RunWith(SpringRunner.class)
public class CategoryControllerWebLayerTest {
		
		@Autowired
		MockMvc mockMvc;
		
		@MockBean
		CategoryRepository categoryRepo;
		
		private Department department;
		private Category category;
		
		private ObjectMapper mapper = new ObjectMapper();
		
		@Before
		public void setup() {
			category = new Category("Category Name", department);
		}
		
		@Test
		public void shouldFetchCollectionOfCategorys() throws Exception {
			when(categoryRepo.findAll()).thenReturn(Collections.singletonList(category));
			mockMvc.perform(get("/api/categorys")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().json("[{}]"))
			.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(category)), true));;
		}
		
		@Test
		public void fetchSingleCategory() throws Exception {
			when(categoryRepo.findById(1L)).thenReturn(Optional.of(category));
			mockMvc.perform(get("/api/Categorys/1")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().json("{}"))
			.andExpect(content().json(mapper.writeValueAsString(category), true));
		}
		
		@Test
		public void createSingleCategory() throws Exception {
			when(categoryRepo.save(any(Category.class))).thenReturn(category);
			when(categoryRepo.findAll()).thenReturn(Collections.singletonList(category));
			mockMvc.perform(post("/api/Categorys")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(mapper.writeValueAsString(category)))
					.andExpect(status().isOk())
					.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(category))));
			}

}
