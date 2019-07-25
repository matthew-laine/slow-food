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

import com.kmstore.slowfood.controllers.CategoryController;
import com.kmstore.slowfood.entities.Category;
import com.kmstore.slowfood.repositories.CategoryRepository;

public class CategoryControllerTest {
	
	@InjectMocks
	private CategoryController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category1;
	
	@Mock
	private Category category2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnListOfCategories() {
		when(categoryRepo.findAll()).thenReturn(Collections.singletonList(category1));
		assertThat(underTest.retrieveAllCategories(), contains(category1));
		
	}
	
	@Test
	public void shouldReturnSingleCategory() {
		when(categoryRepo.findById(1L)).thenReturn(Optional.of(category1));
		assertThat(underTest.retrieveCategory(1L), is(category1));
	}
	
	@Test
	public void shouldSaveSingleCategory() {
		when(categoryRepo.save(any(Category.class))).thenReturn(category1);
		when(categoryRepo.findAll()).thenReturn(Collections.singletonList(category1));
		assertThat(underTest.postSingleCategory(category1), is(Collections.singletonList(category1)));
	}

}