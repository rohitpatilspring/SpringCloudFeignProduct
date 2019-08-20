package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.consumer.CouponConsumer;
import com.app.model.Coupon;
import com.app.model.Product;
import com.app.service.IServiceCoupon;
import com.app.serviceImpl.CouponServiceImpl;
import com.app.serviceImpl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductServiceImpl service;
	
	@Autowired
	IServiceCoupon aa;
	
	@Autowired
	CouponServiceImpl ac;
	
	@Autowired
	CouponConsumer consumer;
	
	@PostMapping("/create")
	public String createCoupon(@RequestBody Product product) {
		Double finalAmount=0.0;
		
		
		String couponCode=product.getCop().getCode();
		
		
		String cct=consumer.findByCode(couponCode).getBody();
		ObjectMapper om=new ObjectMapper();
		Double amt=0.0;
		Coupon cc=null;
		try {
			cc = om.readValue(cct, Coupon.class);
			if(cc!=null) {
			
			 amt=cc.getDiscAmt();
			finalAmount=product.getProCost()-amt;
			product.setProCost(finalAmount);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.createProduct(product);
	
		return "Data Save Sucessfully          ProductCost:="+product.getProCost()+"     Discount="+amt+"            Final Amount:="+finalAmount;
	}

	
	

}
