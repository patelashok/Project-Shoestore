package com.api.ecommerce.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.shoes.exceptions.PurchaseReportException;
import com.api.ecommerce.shoes.exceptions.PurchaseReportNotFoundException;
import com.api.ecommerce.shoes.model.PurchaseReport;
import com.api.ecommerce.shoes.service.PurchaseReportService;

@RestController
public class PurchaseReportController {
	
	@Autowired
	private PurchaseReportService prService;
	
	@PostMapping(value="/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport purchaseReport) throws Exception{
		String tempCustomerName = purchaseReport.getPurchasedCustomerName();
		if(tempCustomerName != null && !"".equals(tempCustomerName)) {
			PurchaseReport prObject = prService.getPurchaseReportByPurchasedCustomerName(tempCustomerName);
			if(prObject != null) {
				throw new PurchaseReportException();
			}
		}
		PurchaseReport pr = null;
		pr = prService.createPurchaseReport(purchaseReport);
		return new ResponseEntity<PurchaseReport>(pr, HttpStatus.CREATED);
	}
	
	@GetMapping(value="admin/purchaseReport/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable("id") int id) throws PurchaseReportNotFoundException{
		PurchaseReport pr = prService.getPurchaseReportById(id);
		return new ResponseEntity<PurchaseReport>(pr, HttpStatus.OK);
	}
	
	@PutMapping(value="admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport purchaseReport) {
		PurchaseReport pr = prService.updatePurchaseReport(purchaseReport);
		return new ResponseEntity<PurchaseReport>(pr, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="admin/purchaseReports/{id}")
	public ResponseEntity<List<PurchaseReport>> deletePurchaseReposeReportById(@PathVariable("id") int id) {
		List<PurchaseReport> prList = prService.deletePurchaseReportById(id);
		return new ResponseEntity<>(prList, HttpStatus.OK);
	}
	
	@GetMapping(value="/admin/purchaseReports")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReports() {
		List<PurchaseReport> prList = prService.getAllPurchaseReports();
		return new ResponseEntity<>(prList, HttpStatus.OK);
	}
	
	@GetMapping(value="/admin/purchaseReports/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable("category") String name) {
		List<PurchaseReport> prList = prService.getAllPurchaseReportsByCategory(name);
		return new ResponseEntity<>(prList, HttpStatus.OK);
	}
}
