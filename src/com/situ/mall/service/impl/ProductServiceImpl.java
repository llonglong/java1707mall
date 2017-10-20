package com.situ.mall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.MallConstant;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IStaticPageService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private IStaticPageService staticPageService;
	
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


	@Override
	public ServerResponse show(Integer id) {
		if (id == null) {
			return ServerResponse.createError("id不能为空");
		}
		Product product = productDao.findById(id);
		if (product == null) {
			return ServerResponse.createError("产品不存在");
		}
		
		Map root = new HashMap();
		root.put("product", product);
		//按照“，”分割subImages，
		String subImagesStr = product.getSubImages();
		if (null != subImagesStr && !subImagesStr.equals("")) {
			String[] subImages = subImagesStr.split(",");
			for (int i = 0; i < subImages.length; i++) {
				subImages[i] = MallConstant.SERVER_ADDRES + subImages[i];
			}
			//放到域对象中
			root.put("subImages", subImages);
		}
		if(staticPageService.productIndex(root, product.getId())){
			return ServerResponse.createSuccess("静态化成功");
		}
		return ServerResponse.createError("静态化失败");
	}
}
