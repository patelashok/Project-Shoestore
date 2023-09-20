package com.api.ecommerce.shoes.service;

import org.springframework.stereotype.Component;

import com.api.ecommerce.shoes.model.User;

@Component
public interface UserService {
	User addUser(User user);
	User getByUserEmailId(String name);
	User getByUserEmailIdAndUserPassword(String email, String pass);
}
