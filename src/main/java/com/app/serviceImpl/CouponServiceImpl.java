package com.app.serviceImpl;




import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.model.Coupon;
import com.app.repo.CouponRepository;
import com.app.service.IServiceCoupon;
@Service
@Transactional
public class CouponServiceImpl implements IServiceCoupon {
    @Autowired
    CouponRepository couponRepository;

	public void createCoupon(Coupon c) {
		// TODO Auto-generated method stub
		couponRepository.save(c);
	}

	@Override
	public Coupon findId(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Coupon findByCode(String code) {
		
		Optional<Coupon> c= couponRepository.findByCode(code);
		
		Coupon cc=c.get();
		
		return cc;
		
	}


	
}