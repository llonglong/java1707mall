package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.OrderItemDao;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderItemService;
@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService{
	@Resource(name="orderItemDao")
	private OrderItemDao orderItemDao;

	@Override
	public List<OrderItem> findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return orderItemDao.findByUserId(id);
	}

}
