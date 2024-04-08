package com.sathya.orm.mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.entity.Product;
import com.sathya.orm.model.ProductDetails;
import com.sathya.orm.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductClient implements CommandLineRunner{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper mapper;
	
	@Override
	public void run(String... args) throws Exception {
//		log.debug("Client code started.................................................");
		//model class data : having the values
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProId(111);
		productDetails.setProName("Sugar");
		productDetails.setProPrice(220);
		
		// conversion of model class data to entity
		Product  product = mapper.modelToEntityConversion(productDetails);
		
		//insert the object into table using save method
		productRepository.save(product);
		log.info("Product added to the database table successfully.................... ");
//		log.warn("This is a warning, first product is added successfully.......................");
		
		//Saving list of objects using saveAll()
		ProductDetails p1 = new ProductDetails();
		p1.setProId(222);
		p1.setProName("Salt");
		p1.setProPrice(20);
		
		ProductDetails p2 = new ProductDetails();
		p2.setProId(333);
		p2.setProName("Mirchi");
		p2.setProPrice(320);
		
		ProductDetails p3 = new ProductDetails();
		p3.setProId(444);
		p3.setProName("Shirt");
		p3.setProPrice(400);
		
		List<ProductDetails> productDetails2 = List.of(p1,p2,p3);
		
		// conversion of model class data to entity
		List<Product> products = mapper.modelToEntityListConversion(productDetails2);
		productRepository.saveAll(products);
		log.info("List of products added to the database table successfully.................... ");
		
		
		System.out.println(productRepository.findByProName("Sugar"));
		
		System.out.println(productRepository.findByProPriceBetween(10, 400));
		
		System.out.println(productRepository.findByProNameStartsWith("S"));
		
		productRepository.deleteByProName("Salt");
		
		productRepository.deleteByProPriceBetween(10, 500);;
//		Optional<Product> optionalProduct= productRepository.findById(111);
//		if(optionalProduct.isPresent())
//		{
//			System.out.println(optionalProduct);
//		}
//		else
//		{
//			System.out.println("Product is not present");
//		}
//		
//		
//		
//		List<Product> products2 = productRepository.findAll();
//		for(Product product2: products2)
//		{
//			System.out.println(product2);
//		}
//		
//		
//		Long count = productRepository.count();
//		System.out.println("The number of records in the table are..."+count);
//		
//		
//		System.out.println("The product exists is...."+productRepository.existsById(111));
//		System.out.println("The product exists is...."+productRepository.existsById(100));
//		
//		productRepository.deleteById(222);
//	
//		productRepository.deleteAll();
	
	}

}
