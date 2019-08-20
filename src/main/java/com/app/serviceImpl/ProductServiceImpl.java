package com.app.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.service.IProductService;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductRepository productRepository;
	
	public void createProduct(Product product) {
		productRepository.save(product);		
	}
	
	public Product getData(Integer productId) {
		 Optional<Product> p= productRepository.findById(productId);
		 Product pp=p.get();
		  return pp;
	}

}
