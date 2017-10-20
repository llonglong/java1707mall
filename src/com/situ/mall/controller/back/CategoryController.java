package com.situ.mall.controller.back;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.ICategoryService;

@Controller
@RequestMapping(value="category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	
	/*@RequestMapping(value="findAll")
	public String findAll(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list",list);
		for (Category category : list) {
			System.out.println(category);
		}
		return "category_list";
	}*/
	@RequestMapping(value="parenCategoryList")
	@ResponseBody
	public List<Category> parenCategoryList() {
		List<Category> list = categoryService.findParentCategory();
		return list; 
	}
	@RequestMapping(value="categoryList")
	@ResponseBody
	public List<Category> categoryList(int parentId) {
		List<Category> list =  categoryService.findCategory(parentId);
		return list;
	}
		
	@RequestMapping("/findParentCategory")
    public  String findParentCategory(Model model) {
		List<Category> Parentlist = categoryService.findParentCategory();
		model.addAttribute("Parentlist",Parentlist);
		for (Category category : Parentlist) {
			System.out.println(category);
		}
		return "category_list";
    }
	
	@RequestMapping("/findCategory")
    public  String findCategory(Model model,int id) {
        List<Category> list = categoryService.findCategory(id);
        model.addAttribute("list",list);
        for (Category category : list) {
			System.out.println(category);
		}
        return "show_category";
    }
	
	@RequestMapping("/deleteCategoryById")
    public  String deleteCategoryById(int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category/findParentCategory.action";
    }
	
	@RequestMapping("/deleteParentById")
    public  String deleteParentById(int id) {
        /*categoryService.deleteCategoryById(id);*/
        categoryService.deleteParentById(id);
        return "redirect:/category/findParentCategory.action";
    }
	
	@RequestMapping("/getAddParentCategory")
    public String getAddParentCategory(){
        return "addParentCategory_list";
    }
	
	@RequestMapping("/getAddCategory")
    public String getAddCategory(Model model){
		List<Category> list = categoryService.findParentCategory();
		model.addAttribute("list",list);
        return "addCategory_list";
    }
	
	@RequestMapping(value="addParentCategory")
	public String addParentCategory(Category category) {
		System.out.println(category);
		categoryService.addParentCategory(category);
		return "redirect:/category/findParentCategory.action";
		/*return "addParentCategory_list";*/
	}
	
	@RequestMapping(value="addCategory")
	public String addCategory(Category category) {
		System.out.println(category);
		categoryService.addCategory(category);
		return "redirect:/category/findParentCategory.action";
		/*return "addParentCategory_list";*/
	}
	
	@RequestMapping(value="findParentById")
	public String findParentById(Model model,int id) {
		Category category = categoryService.findParentById(id);
		model.addAttribute("category",category);
		return "update_parent";	
	}
	
	@RequestMapping(value="findCategoryById")
	public String findCategoryById(Model model,int id) {
		List<Category> list = categoryService.findParentCategory();
		model.addAttribute("list",list);
		Category category = categoryService.findCategoryById(id);
		model.addAttribute("category",category);
		return "update_category";	
	}
	
	@RequestMapping(value="/updateParent")
	public String updateParent(Category category) {
		categoryService.updateParent(category);
		return "redirect:/category/findParentCategory.action";	
	}
	
	@RequestMapping(value="/updateCategory")
	public String updateCategory(Category category) {
		categoryService.updateCategory(category);
		return "redirect:/category/findParentCategory.action";	
	}
}
