package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
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
	public ServerResponse add(Product product) {
		try {
			int rowCount = productDao.add(product);
			if (rowCount > 0) {
				return ServerResponse.createSuccess("添加商品成功");
			} else {
				return ServerResponse.createError("添加商品失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加商品失败");
		}
	}


	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}


	@Override
	public void update(Product product) {
		productDao.update(product);
	}


	@Override
	public void deleteByAll(int[] idArray) {
		productDao.deleteByAll(idArray);
	}


	@Override
	public List<Product> findCategoryListById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findCategoryListById(id);
	}
}
