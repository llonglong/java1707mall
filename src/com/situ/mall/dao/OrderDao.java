package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;

public interface OrderDao {

	int add(Order order);

	int addOrderItem(OrderItem orderItem);

	List<OrderItem> findByUserId(Integer id);

	List<Order> findAll();

	

}
