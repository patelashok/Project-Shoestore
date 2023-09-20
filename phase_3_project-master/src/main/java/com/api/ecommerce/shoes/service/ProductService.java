package com.api.ecommerce.shoes.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.ecommerce.shoes.exceptions.ProductNotFoundException;
import com.api.ecommerce.shoes.model.Product;

@Component
public interface ProductService {
	Product addProduct(Product product);
	Product getById(int id) throws ProductNotFoundException;
	Product updateProduct(Product product);
	List<Product> deleteProductById(int id);
	List<Product> getAllProducts();
	List<Product> getProductByPrice(int price);
	Product getByLabelCode(String name);
}
