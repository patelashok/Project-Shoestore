package com.api.ecommerce.shoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@Column
	private int id;
	@Column
	private String userFirstName;
	@Column
	private String userLastName;
	@Column
	private String userEmailId;
	@Column
	private String userPassword;
	@Column
	private String userContactNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserContactNo() {
		return userContactNo;
	}
	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}
}
