package com.api.ecommerce.shoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.ecommerce.shoes.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUserEmailId(String name);
	User findByUserEmailIdAndUserPassword(String emailId, String password);
}
