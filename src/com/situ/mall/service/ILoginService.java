package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.User;

public interface ILoginService {

	List<User> findAll();

	User getUser(User user);

}
