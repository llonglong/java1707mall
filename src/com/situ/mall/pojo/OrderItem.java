package com.situ.mall.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OrderItem {
	private Integer id;

	private Integer userId;
	
	private BigInteger orderNo;

	private Integer productId;

	private String productName;

	private String productImage;

	private BigDecimal currentUnitPrice;

	private Integer quantity;

	private Integer totalPrice;

	private Date createTime;

	private Date updateTime;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer userId, BigInteger orderNo, Integer productId, String productName,
			String productImage, BigDecimal currentUnitPrice, Integer quantity, Integer totalPrice, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.currentUnitPrice = currentUnitPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigInteger getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(BigInteger orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public BigDecimal getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", productId=" + productId
				+ ", productName=" + productName + ", productImage=" + productImage + ", currentUnitPrice="
				+ currentUnitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	

	
}
