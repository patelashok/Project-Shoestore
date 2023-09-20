package com.api.ecommerce.shoes.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
	public Admin() {
		super();
	}
	public Admin(int id, String adminfirstName, String adminlastName, String adminUserName, String adminPassword,
			String adminContactNo) {
		super();
		this.id = id;
		this.adminfirstName = adminfirstName;
		this.adminlastName = adminlastName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminContactNo = adminContactNo;
	}
	@Id //defining the id as primary key
	@Column
	private int id;
	@Column
	private String adminfirstName;
	@Column
	private String adminlastName;
	@Column
	private String adminUserName;
	@Column
	private String adminPassword;
	@Column
	private String adminContactNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminfirstName() {
		return adminfirstName;
	}
	public void setAdminfirstName(String adminfirstName) {
		this.adminfirstName = adminfirstName;
	}
	public String getAdminlastName() {
		return adminlastName;
	}
	public void setAdminlastName(String adminlastName) {
		this.adminlastName = adminlastName;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminContactNo() {
		return adminContactNo;
	}
	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}
}
