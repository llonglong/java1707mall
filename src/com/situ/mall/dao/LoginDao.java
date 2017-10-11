package com.situ.mall.dao;

import java.util.List;

import com.situ.mall.pojo.User;

public interface LoginDao {

	public List<User> findAll();

	public User getUser(User user);

	
}
