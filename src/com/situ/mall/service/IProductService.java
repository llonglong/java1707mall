package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.Product;

public interface IProductService {

	public List<Product> findAll();

	public void deleteById(int id);

	ServerResponse add(Product product);

	public Product findById(int id);

	public void update(Product product);

	public void deleteByAll(int[] idArray);

	public List<Product> findCategoryListById(Integer id);

	public ServerResponse show(Integer id);

}
