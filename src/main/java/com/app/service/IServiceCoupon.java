package com.app.service;





import com.app.model.Coupon;

public interface IServiceCoupon {
	
	public void createCoupon(Coupon c);
	public Coupon findId(Integer cid);
}
