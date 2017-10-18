package com.situ.mall.service;

import java.math.BigInteger;
import java.util.List;

import com.situ.mall.pojo.OrderItem;

public interface IOrderItemService {

	List<OrderItem> findByUserId(Integer id);

	List<OrderItem> findOrderItemByOrderNO(BigInteger orderNo);
}
