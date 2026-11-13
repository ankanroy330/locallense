package com.locallense.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.locallense.backend.entity.Product;
import com.locallense.backend.repository.ProductRepository;
@Service
public class ProductService {
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	public Product getProductById(Long id) {
	    return productRepository.findById(id)
	            .orElseThrow(() ->
	                new RuntimeException("Product not found: " + id));
	}
	public void deleteProduct(Long id) {
	    Product product = getProductById(id);
	    productRepository.delete(product);
	}
	}
	
