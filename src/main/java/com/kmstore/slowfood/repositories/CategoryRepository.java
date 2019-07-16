package com.kmstore.slowfood.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kmstore.slowfood.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
