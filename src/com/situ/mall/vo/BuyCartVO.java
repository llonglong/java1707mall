package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 购物车
 *
 */
public class BuyCartVO {
	/*购物项集合*/
	private List<CartItemVO> items = new ArrayList<CartItemVO>();
	
	/*继续购物，最后商品的id*/
	private Integer productId;

	public void addItem(CartItemVO cartItemVO) {
		boolean isExit = false;
		for (CartItemVO item : items) {
			//这件商品已经购物车里已经存在，再添加amount+1
			if (item.getProduct().getId() == cartItemVO.getProduct().getId()) {
				isExit = true;
				int amount = item.getAmount() + cartItemVO.getAmount();
				//购买这件商品的总数量应该<=product.stock
				if (amount <= item.getProduct().getStock()) {
					item.setAmount(amount);
				}else {
					//超出购买限制，最大只能购买这件商品的最大库存
					item.setAmount(item.getProduct().getStock());
				}
				break;
			}
		}
		//这件商品原来没有加入购物车,加入购物车
		if (isExit == false) {
			items.add(cartItemVO);
		}
	}
	
	public void delItems(Integer productId) {
		Iterator<CartItemVO> iterator = items.iterator();
		while (iterator.hasNext()) {
			CartItemVO cartItemVO = (CartItemVO) iterator.next();
			if (cartItemVO.getProduct().getId() == productId) {
				iterator.remove();
			}
		}

	}
	
	@JsonIgnore
	public double getTotalPrice() {
		Double totalPrice = 0.0;
		for (CartItemVO item : items) {
			totalPrice += item.getAmount() * item.getProduct().getPrice().doubleValue();
		}
		return totalPrice;
	}

	public List<CartItemVO> getItems() {
		return items;
	}

	public void setItems(List<CartItemVO> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "BuyCartVO [items=" + items + ", productId=" + productId + "]";
	}
	
	
	
	
}
