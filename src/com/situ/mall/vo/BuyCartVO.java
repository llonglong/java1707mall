package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * ���ﳵ
 *
 */
public class BuyCartVO {
	/*�������*/
	private List<CartItemVO> items = new ArrayList<CartItemVO>();
	
	/*������������Ʒ��id*/
	private Integer productId;

	public void addItem(CartItemVO cartItemVO) {
		boolean isExit = false;
		for (CartItemVO item : items) {
			//�����Ʒ�Ѿ����ﳵ���Ѿ����ڣ������amount+1
			if (item.getProduct().getId() == cartItemVO.getProduct().getId()) {
				isExit = true;
				int amount = item.getAmount() + cartItemVO.getAmount();
				//���������Ʒ��������Ӧ��<=product.stock
				if (amount <= item.getProduct().getStock()) {
					item.setAmount(amount);
				}else {
					//�����������ƣ����ֻ�ܹ��������Ʒ�������
					item.setAmount(item.getProduct().getStock());
				}
				break;
			}
		}
		//�����Ʒԭ��û�м��빺�ﳵ,���빺�ﳵ
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
