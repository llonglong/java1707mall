package com.situ.mall.controller.front;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginService;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IShippingService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

@Controller
@RequestMapping(value="order")
public class FrontOrderController {
	
	/*@Autowired
	private IShippingService shippingService;*/
	@Resource(name="loginService")
	private ILoginService loginService;
	
	@Resource(name="shippingService")
	private IShippingService shippingService;
	
	@Resource(name="productService")
	private IProductService productService;
	
	@RequestMapping("/prepareOrder.shtml")
    public String prepareOrder(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		User userNew = loginService.getUser(user);
		model.addAttribute("userNew",userNew);
		System.out.println(userNew);
		Shipping shipping = shippingService.findByUserId(userNew.getId());
		System.out.println(shipping);
		model.addAttribute("shipping",shipping);
		
		ObjectMapper objectMapper = new ObjectMapper();
		//只有对象里面不是null的才转换
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		BuyCartVO buyCartVO = null;
		//1.如果cookie有这个购物车对象，那就从cookie里面取出这个购物车对象
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if ("buy_cart_cookies".equals(cookie.getName())) {
					//之前购物车中已经存在
					//"{\"items\":[{\"product\":{\"id\":45},\"amount\":1}],\"productId\":45}"
					String value = cookie.getValue();
					try {
						buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		List<CartItemVO> items = buyCartVO.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}
		model.addAttribute("buyCartVO",buyCartVO);
		System.out.println(buyCartVO);		
		return "order";
	}

}
