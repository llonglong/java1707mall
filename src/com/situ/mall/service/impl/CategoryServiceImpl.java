package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.CategoryDao;
import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService{

	@Resource(name="categoryDao")
	private CategoryDao categoryDao;

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findParentCategory() {
		return categoryDao.findParentCategory();
	}

	@Override
	public List<Category> findPCategory(int parentId) {
		return categoryDao.findPCategory(parentId);
	}

	
}
