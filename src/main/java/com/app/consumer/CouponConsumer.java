package com.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COUPON-SERVICE")
public interface CouponConsumer {
	
/*	@PostMapping("/coupon/create")
	public String createCoupon(@RequestBody Coupon coupon);*/
	
	@GetMapping("/coupon/one/{cid}")
	public String getOne(@PathVariable Integer cid);
	
	@GetMapping("/coupon/cc/{code}")
	public ResponseEntity<String>  findByCode(@PathVariable String code);

}
