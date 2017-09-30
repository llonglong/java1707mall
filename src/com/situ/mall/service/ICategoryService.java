package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Category;

public interface ICategoryService {

	List<Category> findAll();

	List<Category> findParentCategory();

	List<Category> findCategory(int id);

	void deleteCategoryById(int id);

	void addParentCategory(Category category);

	void addCategory(Category category);

	void deleteParentById(int id);

	Category findParentById(int id);

	void updateParent(Category category);

	Category findCategoryById(int id);

	void updateCategory(Category category);

	
}
