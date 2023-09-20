package com.api.ecommerce.shoes.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.ecommerce.shoes.exceptions.PurchaseReportNotFoundException;
import com.api.ecommerce.shoes.model.PurchaseReport;

@Component
public interface PurchaseReportService {
	PurchaseReport createPurchaseReport(PurchaseReport purchaseReport);
	PurchaseReport getPurchaseReportByPurchasedCustomerName(String name);
	PurchaseReport getPurchaseReportById(int id) throws PurchaseReportNotFoundException;
	PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport);
	List<PurchaseReport> deletePurchaseReportById(int id);
	List<PurchaseReport> getAllPurchaseReports();
	List<PurchaseReport> getAllPurchaseReportsByCategory(String name);
}
