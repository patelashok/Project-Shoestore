package com.api.ecommerce.shoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class PurchaseReport {
	
	@Id
	@Column
	private int id;
	@Column
	private String purchasedCustomerName;
	@Column
	private  String category;
	@Column
	private String dateOfPurchase;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurchasedCustomerName() {
		return purchasedCustomerName;
	}
	public void setPurchasedCustomerName(String purchasedCustomerName) {
		this.purchasedCustomerName = purchasedCustomerName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
}
