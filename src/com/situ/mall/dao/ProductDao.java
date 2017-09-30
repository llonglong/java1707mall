package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Product;

public interface ProductDao {

	public List<Product> findAll();

	public void deleteById(int id);

	public void add(Product product);

	public Product findById(int id);

	public void update(Product product);

	public void deleteByAll(int[] idArray);

}
