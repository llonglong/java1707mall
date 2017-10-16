package com.situ.mall.service;

import com.situ.mall.pojo.Shipping;

public interface IShippingService {

	Shipping findByUserId(Integer id);

}
