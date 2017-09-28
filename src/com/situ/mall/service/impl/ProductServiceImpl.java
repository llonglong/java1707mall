package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService{
	
	@Resource(name="productDao")
	private ProductDao productDao;

	
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}


	@Override
	public void deleteById(int id) {
		productDao.deleteById(id);
	}


	@Override
	public void add(Product product) {
		productDao.add(product);
		
	}


	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}


	@Override
	public void update(Product product) {
		productDao.update(product);
	}
}
