package com.locallense.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locallense.backend.entity.Product;
import com.locallense.backend.service.ProductService;
@RestController
@RequestMapping("/api/products")
public class ProductController {
	private ProductService productService;
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping
	public List<Product>getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable ("id") Long id) {
		return productService.getProductById(id);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id")Long id,
	                             @RequestBody Product product) {
	    Product existingProduct = productService.getProductById(id);

	    existingProduct.setName(product.getName());
	    existingProduct.setBrand(product.getBrand());
	    existingProduct.setCategory(product.getCategory());
	    existingProduct.setPrice(product.getPrice());
	    existingProduct.setStock(product.getStock());

	    return productService.saveProduct(existingProduct);
	}
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
	    productService.deleteProduct(id);
	    return "Product deleted successfully with ID: " + id;
	}
	
}
