package com.sathya.orm.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm.entity.Product;
import com.sathya.orm.model.ProductDetails;

@Component
public class ProductMapper {
	//This method takes model class as input and return entity class as output
	public Product modelToEntityConversion(ProductDetails productDetails)
	{
		//read the data from model class set to entity class
		Product product = new Product();
		product.setProId(productDetails.getProId());
		product.setProName(productDetails.getProName());
		product.setProPrice(productDetails.getProPrice());
		product.setCreatedBy(System.getProperty("user.name"));
		product.setCreatedAt(LocalDateTime.now());
		return product;
	}
	
	
	//This method takes the list of models as input and returns list of entities as output
	public List<Product> modelToEntityListConversion(List<ProductDetails> productDetails)
	{
		List<Product> ps = new ArrayList<Product>();
		for(ProductDetails productDetail: productDetails) {
			Product product2 = new Product();
			product2.setProId(productDetail.getProId());
			product2.setProName(productDetail.getProName());
			product2.setProPrice(productDetail.getProPrice());
			product2.setCreatedBy(System.getProperty("user.name"));
			product2.setCreatedAt(LocalDateTime.now());
			ps.add(product2);
		}
		return ps;
	}
}
