package com.locallense.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locallense.backend.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

	

