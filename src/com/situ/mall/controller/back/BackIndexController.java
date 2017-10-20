package com.situ.mall.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/index")
public class BackIndexController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
