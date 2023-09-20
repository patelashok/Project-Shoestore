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

import com.api.ecommerce.shoes.exceptions.ProductException;
import com.api.ecommerce.shoes.exceptions.ProductNotFoundException;
import com.api.ecommerce.shoes.model.Product;
import com.api.ecommerce.shoes.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value="/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception{
		String tempLabelName = product.getLabelCode();
		if(tempLabelName != null && !"".equals(tempLabelName)) {
			Product productObj = productService.getByLabelCode(tempLabelName);
		    if(productObj != null ) {
		    	throw new ProductException();
		    }
		}
		Product productobj = null;
		 productobj = productService.addProduct(product);
		return new ResponseEntity<Product>(productobj, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/products/{id}")
	public ResponseEntity<Product> getByProductId(@PathVariable("id") int id) throws ProductNotFoundException {
			  Product product = productService.getById(id);
			  return new ResponseEntity<Product>(product, HttpStatus.OK);	
	}
	
	@PutMapping(value="/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product pro= productService.updateProduct(product);
		return new ResponseEntity<Product>(pro,HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/products/{id}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable("id") int id) {
		List<Product> productList = productService.deleteProductById(id);
		return new ResponseEntity<>(productList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@GetMapping(value="/products/price/{price}")
	public ResponseEntity<List<Product>> getProductByPrice(@PathVariable("price") int price) {
		List<Product> productList = productService.getProductByPrice(price);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
}
