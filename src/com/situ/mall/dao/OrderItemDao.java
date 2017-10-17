package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.OrderItem;

public interface OrderItemDao {

	List<OrderItem> findByUserId(Integer id);

}
