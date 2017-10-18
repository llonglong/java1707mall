package com.situ.mall.controller.front;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Resource(name="loginService")
	private ILoginService loginService;
	
	@RequestMapping(value="/toLogin.shtml")
	public String toLogin(Model model) {
		List<User> list = loginService.findAll();
		model.addAttribute("list",list);
		for (User user : list) {
			System.out.println(user);
		}
		return "login";
	}
	
	
	@RequestMapping(value="/loginIndex.shtml")
	@ResponseBody
	public ServerResponse login(Model model, HttpServletRequest req, User user) {
		
		User resultUser = loginService.getUser(user);
		if (user != null && resultUser != null) {
			if (user.getUsername().equals(resultUser.getUsername() ) && user.getPassword().equals(resultUser.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				return ServerResponse.createSuccess("µÇÂ¼³É¹¦");
			} else {
				return ServerResponse.createError("µÇÂ¼Ê§°Ü");
			}
		} else {
			return ServerResponse.createError("µÇÂ¼Ê§°Ü");
		}
		
	}
	
	@RequestMapping(value="toRegister.shtml")
	public String toRegister() {
		return "register";
	}
	
	/*@RequestMapping(value="register.shtml")
	public String register(User user) {
		boolean result = loginService.addUser(user);
		return "redirect:/login/toLogin.shtml";
	}*/
	
	@RequestMapping(value="judgeLogin.shtml")
	public String judgeLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (session == null) {
			return "login";
		}
		if(user == null) {
			return "login";
		}
		else{
			return "redirect:/order/prepareOrder.shtml";
		}
	}
	
}
