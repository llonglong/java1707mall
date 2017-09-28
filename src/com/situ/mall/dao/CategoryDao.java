package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.Category;

public interface CategoryDao {

	List<Category> findAll();

	

	List<Category> findParentCategory();



	List<Category> findPCategory(int parentId);

}
