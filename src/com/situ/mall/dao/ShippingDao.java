package com.situ.mall.dao;

import com.situ.mall.pojo.Shipping;

public interface ShippingDao {

	Shipping findByUserId(Integer id);

}
