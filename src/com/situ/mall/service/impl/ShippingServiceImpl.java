package com.situ.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.ShippingDao;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShippingService;
@Service("shippingService")
public class ShippingServiceImpl implements IShippingService{

	@Resource(name="shippingDao")
	private ShippingDao shippingDao;
	
	@Override
	public Shipping findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return shippingDao.findByUserId(id);
	}

}
