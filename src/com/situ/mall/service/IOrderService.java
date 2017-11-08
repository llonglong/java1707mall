package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;

public interface IOrderService {

	boolean add(Order order);

	boolean addOrderItem(OrderItem orderItem);

	List<Order> findAll();

	List<Order> findByUserId(Integer id);

	void deleteById(Integer id);


}
