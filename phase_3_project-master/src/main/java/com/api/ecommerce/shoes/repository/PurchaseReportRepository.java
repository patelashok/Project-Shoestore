package com.api.ecommerce.shoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.ecommerce.shoes.model.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends CrudRepository<PurchaseReport, Integer> {
	PurchaseReport findByPurchasedCustomerName(String name);
	List<PurchaseReport> findAll();
	List<PurchaseReport> findByCategory(String name);
}
