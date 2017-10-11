package com.situ.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.mall.dao.LoginDao;
import com.situ.mall.dao.ProductDao;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Resource(name="loginDao")
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
