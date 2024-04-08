package com.sathya.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.orm.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Product findByProName(String proName);
	
	public List<Product> findByProPriceBetween(double minPrice, double maxPrice);
	
	public List<Product> findByProNameStartsWith(String starts);
	
	@Transactional
	public void deleteByProName(String name);
	
	@Transactional
	public void deleteByProPriceBetween(double minPrice, double maxPrice);

}
