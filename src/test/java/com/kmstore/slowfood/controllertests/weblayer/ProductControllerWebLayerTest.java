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
import com.kmstore.slowfood.controllers.ProductController;
import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.entities.Product;
import com.kmstore.slowfood.repositories.ProductRepository;

@WebMvcTest(ProductController.class)
@RunWith(SpringRunner.class)
public class ProductControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductRepository productRepo;
	
	private Department department;
	private Category category;
	private Product product;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		category = new Category("Category Name", department);
		product = new Product("Product Name", "url", category);
	}
	
	@Test
	public void shouldFetchCollectionOfProducts() throws Exception {
		when(productRepo.findAll()).thenReturn(Collections.singletonList(product));
		mockMvc.perform(get("/api/products")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("[{}]"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(product)), true));;
	}
	
	@Test
	public void fetchSingleProduct() throws Exception {
		when(productRepo.findById(1L)).thenReturn(Optional.of(product));
		mockMvc.perform(get("/api/products/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("{}"))
		.andExpect(content().json(mapper.writeValueAsString(product), true));
	}
	
	@Test
	public void createSingleProduct() throws Exception {
		when(productRepo.save(any(Product.class))).thenReturn(product);
		when(productRepo.findAll()).thenReturn(Collections.singletonList(product));
		mockMvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(product)))
				.andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(product))));
		}

}
