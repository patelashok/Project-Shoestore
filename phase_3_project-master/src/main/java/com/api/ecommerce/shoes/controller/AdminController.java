package com.api.ecommerce.shoes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.ecommerce.shoes.exceptions.AdminException;
import com.api.ecommerce.shoes.exceptions.AdminUserNotFoundException;
import com.api.ecommerce.shoes.exceptions.LoginException;
import com.api.ecommerce.shoes.model.Admin;
import com.api.ecommerce.shoes.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired 
	private AdminService adminService;
	
	@PostMapping(value="/adminUsers")
	public ResponseEntity<Admin> addAdminUser(@RequestBody Admin admin) throws Exception {
		String tempUserName = admin.getAdminUserName();
		if (tempUserName != null && ! "".equals(tempUserName)) {
			Admin adminobj = adminService.getAdminUser(tempUserName);
			if (adminobj != null) {
				throw new AdminException();
			}
		}
		Admin adminObj = null;
		adminObj = adminService.addAdminUser(admin);
		return new ResponseEntity<Admin>(adminObj, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/adminUsers/{adminUserName}")
	public ResponseEntity<Admin> getAdminUser(@PathVariable("adminUserName") String adminUserName) throws Exception{
		
		Admin admin = adminService.getAdminUser(adminUserName);
		if(admin == null) {
			throw new AdminUserNotFoundException();
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Admin> getAdminUserByUserNameAndPassword(@RequestBody Admin admin) throws Exception {
		String tempUserName = admin.getAdminUserName();
		String tempPass = admin.getAdminPassword();
		Admin adminUser = null;
		if (tempUserName != null && tempPass != null) {
			adminUser = adminService.getAdminUserByUserNameAndAdminPassword(tempUserName, tempPass);			
		}
		if (adminUser == null) {
			throw new LoginException();
		}
		return new ResponseEntity<Admin>(adminUser, HttpStatus.OK);
	}
}
