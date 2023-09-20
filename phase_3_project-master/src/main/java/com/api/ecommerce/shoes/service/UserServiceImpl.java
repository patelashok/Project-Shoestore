package com.api.ecommerce.shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ecommerce.shoes.model.User;
import com.api.ecommerce.shoes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public User getByUserEmailId(String name) {
		return userRepo.findByUserEmailId(name);
	}
	
	public User getByUserEmailIdAndUserPassword(String eid, String pwd) {
		return userRepo.findByUserEmailIdAndUserPassword(eid, pwd);
	}
}
