//wrapper class for our ORM
package com.LateNightIce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LateNightIce.models.Product;
import com.LateNightIce.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	public ProductService(ProductRepository pr) {
		productRepo = pr;
	}
	
	
	
	public List<Product> listAll() {
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product get(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
	        return product.get();
	    }
		else {
	        return null;
	    }
	}
	
	public void save(Product p) {
		productRepo.save(p);
	}
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
}