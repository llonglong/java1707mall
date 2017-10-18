package com.situ.mall.controller.back;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping(value="product")
public class ProductController {
	
	@Resource(name="productService")
	private IProductService productService;
	
	@Resource(name="categoryService")
	private ICategoryService categoryService;
	
	@RequestMapping(value="findAll")
	public String findAll(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list",list);
		for (Product product : list) {
			System.out.println(product);
		}
		return "product_list";
	}
	
	@RequestMapping(value="deleteById")
	public String deleteById(int id) {
		productService.deleteById(id);
		return "redirect:/product/findAll.action";
	}
	
	@RequestMapping(value="deleteAll")
	public String deleteAll(int[] selectIds) {
		for (int i : selectIds) {
			System.out.println(i);
			productService.deleteById(i);
		}
		
		return "redirect:/product/findAll.action";
	}
	
	@RequestMapping(value="findById")
	public String findById(Model model,int id) {
		Product product = productService.findById(id);
		model.addAttribute("product",product);
		System.out.println(product);
		return "update_product";
	}
	
	@RequestMapping(value="/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/product/findAll.action";
		
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public ServerResponse add(Product product) {
		return productService.add(product);
		/*return "redirect:/product/findAll.action";*/
	}
	
	@RequestMapping(value="getTurn")
	public String getTurn(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list",list);
		for (Category category : list) {
			System.out.println(category);
		}
		return "add_product";
	}
	
}
