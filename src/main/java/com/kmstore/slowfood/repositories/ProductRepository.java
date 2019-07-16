package com.kmstore.slowfood.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kmstore.slowfood.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
