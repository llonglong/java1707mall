package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.dao.LoginDao;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private LoginDao loginDao;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return loginDao.findAll();
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return loginDao.getUser(user);
	}
	
	

}
