package com.situ.mall.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.OrderItemDao;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderItemService;
@Service
public class OrderItemServiceImpl implements IOrderItemService{
	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public List<OrderItem> findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return orderItemDao.findByUserId(id);
	}

	@Override
	public List<OrderItem> findOrderItemByOrderNO(BigInteger orderNo) {
		// TODO Auto-generated method stub
		return orderItemDao.findOrderItemByOrderNO(orderNo);
	}



}
