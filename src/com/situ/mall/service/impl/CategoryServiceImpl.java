package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.CategoryDao;
import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
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
	public List<Category> findCategory(int id) {
		return categoryDao.findCategory(id);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryDao.deleteCategoryById(id);
	}

	@Override
	public void addParentCategory(Category category) {
		categoryDao.addParentCategory(category);
	}

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	public void deleteParentById(int id) {
		categoryDao.deleteParentById(id);
	}

	@Override
	public Category findParentById(int id) {
		return categoryDao.findParentById(id);
	}

	@Override
	public void updateParent(Category category) {
		categoryDao.updateParent(category);
	}

	@Override
	public Category findCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	

	
}
