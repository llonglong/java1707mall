package com.situ.mall.controller.front;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;

@Controller
public class IndexController {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/index.shtml")
	public String index(Model model) {
		List<Category> Parentlist = categoryService.findParentCategory();
		model.addAttribute("Parentlist",Parentlist);
		List<Category> list = categoryService.findAll();
		model.addAttribute("list",list);
		return "index";
	}
}
