package com.kmstore.slowfood.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kmstore.slowfood.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	Department findByName(String name);

}
