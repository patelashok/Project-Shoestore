package com.api.ecommerce.shoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ecommerce.shoes.exceptions.PurchaseReportNotFoundException;
import com.api.ecommerce.shoes.model.PurchaseReport;
import com.api.ecommerce.shoes.repository.PurchaseReportRepository;

@Service
public class PurchaseReportServiceImpl implements PurchaseReportService{
	
	@Autowired
	private PurchaseReportRepository prRepo;
	
	public PurchaseReport createPurchaseReport(PurchaseReport purchaseReport) {
		return prRepo.save(purchaseReport);
	}

	public PurchaseReport getPurchaseReportByPurchasedCustomerName(String name) {
		return prRepo.findByPurchasedCustomerName(name);
	}

	public PurchaseReport getPurchaseReportById(int id) throws PurchaseReportNotFoundException {
		return prRepo.findById(id).orElseThrow(()-> new PurchaseReportNotFoundException());
	}

	public PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport) {
		return prRepo.save(purchaseReport);
	}

	public List<PurchaseReport> deletePurchaseReportById(int id) {
		List<PurchaseReport> purchaseReportList = new ArrayList<PurchaseReport>();
		prRepo.deleteById(id);
		purchaseReportList = prRepo.findAll().stream().collect(Collectors.toList());
		return purchaseReportList;
	}

	public List<PurchaseReport> getAllPurchaseReports() {
		List<PurchaseReport> purchaseReportList = new ArrayList<PurchaseReport>();
		purchaseReportList = prRepo.findAll().stream().collect(Collectors.toList());
		return purchaseReportList;
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(String name) {
		return prRepo.findByCategory(name);
	}
}


