package com.api.ecommerce.shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ecommerce.shoes.model.Admin;
import com.api.ecommerce.shoes.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	/* This method will add new admin user */
	public Admin addAdminUser(Admin admin) {
		return adminRepository.save(admin);	
	}
	
	public Admin getAdminUser(String name) {
		return adminRepository.findByAdminUserName(name);
	}
	
	public Admin getAdminUserByUserNameAndAdminPassword(String uname, String pwd) {
		return adminRepository.findByAdminUserNameAndAdminPassword(uname, pwd);
	}
}
