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

import com.kmstore.slowfood.entities.Department;
import com.kmstore.slowfood.repositories.DepartmentRepository;

public class DepartmentControllerTest {
	
	@InjectMocks
	private DepartmentController underTest;
	
	@Mock
	private DepartmentRepository departmentRepo;
	
	@Mock
	private Department department1;
	
	@Mock
	private Department department2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnListOfDepartments() {
		when(departmentRepo.findAll()).thenReturn(Collections.singletonList(department1));
		assertThat(underTest.retrieveAllDepartments(), contains(department1));
		
	}
	
	@Test
	public void shouldReturnSingleDepartment() {
		when(departmentRepo.findById(1L)).thenReturn(Optional.of(department1));
		assertThat(underTest.retrieveDepartment(1L), is(department1));
	}
	
	@Test
	public void shouldSaveSingleDepartment() {
		when(departmentRepo.save(any(Artist.class))).thenReturn(department1);
		when(departmentRepo.findAll()).thenReturn(Collections.singletonList(department1));
		assertThat(underTest.postOneArtist(department1), is(Collections.singletonList(department1)));
	}

}
