package com.situ.mall.service;

import java.util.Map;

public interface IStaticPageService {
	/**
	 * 商品详情页静态化
	 * @param root 数据
	 * @param id  商品id
	 */
	public void productIndex(Map<String,Object> root,Integer id);
}
