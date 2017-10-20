package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.OrderDao;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderService;
@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	
	@Resource(name="orderDao")
	private OrderDao orderDao;

	@Override
	public boolean add(Order order) {
		int rowCount = orderDao.add(order);
		return rowCount > 0 ? true : false;
	}

	@Override
	public boolean addOrderItem(OrderItem orderItem) {
		int rowCount = orderDao.addOrderItem(orderItem);
		return rowCount > 0 ? true : false;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public List<Order> findByUserId(Integer id) {
		return orderDao.findByUserId(id);
	}

	

}
