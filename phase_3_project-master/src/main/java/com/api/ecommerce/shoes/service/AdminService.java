package com.api.ecommerce.shoes.service;

import com.api.ecommerce.shoes.model.Admin;


public interface AdminService {
   public Admin addAdminUser(Admin admin);
	public Admin getAdminUser(String name);
	public Admin getAdminUserByUserNameAndAdminPassword(String tempUserName, String tempPass);
}
