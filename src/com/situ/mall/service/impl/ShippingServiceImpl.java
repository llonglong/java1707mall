package com.situ.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.ShippingDao;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShippingService;
@Service
public class ShippingServiceImpl implements IShippingService{

	@Autowired
	private ShippingDao shippingDao;
	
	@Override
	public Shipping findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return shippingDao.findByUserId(id);
	}

}
