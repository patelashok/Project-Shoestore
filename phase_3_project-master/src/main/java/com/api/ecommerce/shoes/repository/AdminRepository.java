package com.api.ecommerce.shoes.repository;
import org.springframework.data.repository.CrudRepository;
import com.api.ecommerce.shoes.model.Admin;


public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	public Admin findByAdminUserName(String name);
	public Admin findByAdminUserNameAndAdminPassword(String userName, String password);
	
}
