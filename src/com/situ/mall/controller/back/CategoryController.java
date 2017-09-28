package com.situ.mall.controller.back;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;

@Controller
@RequestMapping(value="category")
public class CategoryController {

	@Resource(name="categoryService")
	private ICategoryService categoryService;
	
	
	@RequestMapping("/findParentCategory")
    public @ResponseBody List<Category> findParentCategory() {
       return categoryService.findParentCategory();
    }
	
	@RequestMapping("/findPCategory")
    public @ResponseBody List<Category> findPCategory(int parentId) {
        List<Category> list = categoryService.findPCategory(parentId);
        for (Category category : list) {
			System.out.println(category);
		}
        return list;
    }
	
	
}
