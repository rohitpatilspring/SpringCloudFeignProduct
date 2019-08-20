package com.app.service;

import com.app.model.Product;

public interface IProductService {
	
	public void createProduct(Product product);
	
	public Product getData(Integer productId);

}
