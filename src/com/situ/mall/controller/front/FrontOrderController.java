package com.situ.mall.controller.front;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ILoginService;
import com.situ.mall.service.IOrderItemService;
import com.situ.mall.service.IOrderService;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IShippingService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

@Controller
@RequestMapping(value="order")
public class FrontOrderController {
	
	/*@Autowired
	private IShippingService shippingService;*/
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IShippingService shippingService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemService orderItemService;
	
	@RequestMapping("/prepareOrder.shtml")
    public String prepareOrder(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		System.out.println("user" + user);
		User userNew = loginService.getUser(user);
		model.addAttribute("userNew",userNew);
		System.out.println("userNew" + userNew);
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
	
	@RequestMapping("/addOrder.shtml")
	public String addOrder(Model model,HttpServletRequest request,HttpServletResponse response){
		Order order = new Order();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		String dataStr = simpleDateFormat.format(date);
		BigInteger orderNo = new BigInteger(dataStr);
		order.setOrderNo(orderNo);
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		User userNew = loginService.getUser(user);
		order.setUserId(userNew.getId());
		Shipping shipping = shippingService.findByUserId(userNew.getId());
		
		order.setShippingId(shipping.getId());
		model.addAttribute("shipping",shipping);
		Integer status = 10;
		order.setStatus(status);

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
			OrderItem orderItem = new OrderItem();
			Integer productId = item.getProduct().getId();
			//商品id
			orderItem.setProductId(productId);
			
			Product product = productService.findById(productId);
			String productName = product.getName();
			//商品name
			orderItem.setProductName(productName);
			String productImage = product.getFullUrl();
			//商品image
			orderItem.setProductImage(productImage);
			//商品单价
			orderItem.setCurrentUnitPrice(product.getPrice());
			//商品总价
			int totalPrice = product.getPrice().intValue() * item.getAmount();
			orderItem.setTotalPrice(totalPrice);
			/*int payment = totalPrice;
			order.setPayment(payment);*/
			//商品数量
			orderItem.setQuantity(item.getAmount());
			orderItem.setUserId(userNew.getId());
			orderItem.setOrderNo(orderNo);
			boolean resultItem = orderService.addOrderItem(orderItem);
			System.out.println(orderItem);
		}
		
		/*int payment = 0;*/
		
		List<OrderItem> list = orderItemService.findByUserId(userNew.getId());
		/*for (OrderItem orderItemList : list) {
			payment += orderItemList.getTotalPrice();
			System.out.println(orderItemList);
			System.out.println(payment);
		}
		order.setPayment(payment);*/
		boolean result = orderService.add(order);
		model.addAttribute("list",list);
		model.addAttribute("order",order);
		System.out.println(order);
		
		//清除购物车
		Cookie cookie = new Cookie("buy_cart_cookies",null);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);

		return "order_list";
	}
	
	@RequestMapping("/findOrderByUserId.shtml")
	public String findOrderByUserId(Model model,HttpServletRequest request){
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		User userNew = loginService.getUser(user);
		System.out.println(userNew);
		Shipping shipping = shippingService.findByUserId(userNew.getId());
		List<Order> orderList = orderService.findByUserId(userNew.getId());
		List<OrderItem> orderItemList = orderItemService.findByUserId(userNew.getId());
		model.addAttribute("shipping",shipping);
		model.addAttribute("orderList",orderList);
		model.addAttribute("orderItemList",orderItemList);
		System.out.println(orderItemList);
		return "allOrder";
	}

}
