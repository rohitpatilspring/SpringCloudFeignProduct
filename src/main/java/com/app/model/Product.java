package com.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Product {
	@Id
	private Integer productId;
	private String prodCode;
	private Double proCost;
	
	//@OneToMany
	//@JoinColumn(name="copid")
	@Autowired
	@Transient
	private Coupon  cop;
	public Product() {
		super();
	}
	
	public Product(Integer productId, String prodCode, Double proCost, Coupon cop) {
		super();
		this.productId = productId;
		this.prodCode = prodCode;
		this.proCost = proCost;
		this.cop = cop;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public Double getProCost() {
		return proCost;
	}

	public void setProCost(Double proCost) {
		this.proCost = proCost;
	}

	public Coupon getCop() {
		return cop;
	}

	public void setCop(Coupon cop) {
		this.cop = cop;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodCode=" + prodCode + ", proCost=" + proCost + ", cop=" + cop
				+ "]";
	}
	
	
	
}
