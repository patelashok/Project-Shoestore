package com.api.ecommerce.shoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.ecommerce.shoes.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findAll(); 
	Product getByLabelCode(String name);
}
