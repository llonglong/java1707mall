package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Category;

public interface ICategoryService {

	List<Category> findAll();

	List<Category> findParentCategory();

	List<Category> findPCategory(int parentId);

}
