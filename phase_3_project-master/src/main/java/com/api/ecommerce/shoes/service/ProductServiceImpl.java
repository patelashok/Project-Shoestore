package com.api.ecommerce.shoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ecommerce.shoes.exceptions.ProductNotFoundException;
import com.api.ecommerce.shoes.model.Product;
import com.api.ecommerce.shoes.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product getById(int id) throws ProductNotFoundException {
		return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException());
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> deleteProductById(int id) {
		List<Product> productList = new ArrayList<Product>();
		productRepo.deleteById(id);
		productList = productRepo.findAll().stream().collect(Collectors.toList());
		return productList;
	}
	
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		productList = productRepo.findAll().stream().collect(Collectors.toList());
		return productList;
	}
	
	public List<Product> getProductByPrice(int price) {
		List<Product> productList = new ArrayList<Product>();
		productList = productRepo.findAll().stream().filter(i -> i.getPrice() <= price).collect(Collectors.toList());
		return productList;
	}

	public Product getByLabelCode(String name) {
		return productRepo.getByLabelCode(name);
	}
}
