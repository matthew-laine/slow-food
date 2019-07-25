package com.kmstore.slowfood.controllertests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kmstore.slowfood.controllers.ProductController;
import com.kmstore.slowfood.entities.Product;
import com.kmstore.slowfood.repositories.ProductRepository;

public class ProductControllerTest {
	
	@InjectMocks
	private ProductController underTest;
	
	@Mock
	private ProductRepository productRepo;
	
	@Mock
	private Product product1;
	
	@Mock
	private Product product2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnListOfProducts() {
		when(productRepo.findAll()).thenReturn(Collections.singletonList(product1));
		assertThat(underTest.retrieveAllProducts(), contains(product1));
		
	}
	
	@Test
	public void shouldReturnSingleProduct() {
		when(productRepo.findById(1L)).thenReturn(Optional.of(product1));
		assertThat(underTest.retrieveProduct(1L), is(product1));
	}
	
	@Test
	public void shouldSaveSingleProduct() {
		when(productRepo.save(any(Product.class))).thenReturn(product1);
		when(productRepo.findAll()).thenReturn(Collections.singletonList(product1));
		assertThat(underTest.postSingleProduct(product1), is(Collections.singletonList(product1)));
	}

}
