package com.situ.mall.controller.back;

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
public class OrderController {
	
	/*@Autowired
	private IShippingService shippingService;*/
	@Resource(name="loginService")
	private ILoginService loginService;
	
	@Resource(name="shippingService")
	private IShippingService shippingService;
	
	@Resource(name="productService")
	private IProductService productService;
	
	@Resource(name="orderService")
	private IOrderService orderService;
	
	@Resource(name="orderItemService")
	private IOrderItemService orderItemService;
	
	@RequestMapping("/prepareOrder")
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
		//ֻ�ж������治��null�Ĳ�ת��
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		BuyCartVO buyCartVO = null;
		//1.���cookie��������ﳵ�����Ǿʹ�cookie����ȡ��������ﳵ����
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if ("buy_cart_cookies".equals(cookie.getName())) {
					//֮ǰ���ﳵ���Ѿ�����
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
	
	@RequestMapping("/addOrder")
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
		Integer status = 10;
		order.setStatus(status);
		
		boolean result = orderService.add(order);
		
		ObjectMapper objectMapper = new ObjectMapper();
		//ֻ�ж������治��null�Ĳ�ת��
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		BuyCartVO buyCartVO = null;
		//1.���cookie��������ﳵ�����Ǿʹ�cookie����ȡ��������ﳵ����
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if ("buy_cart_cookies".equals(cookie.getName())) {
					//֮ǰ���ﳵ���Ѿ�����
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
			//��Ʒid
			orderItem.setProductId(productId);
			
			Product product = productService.findById(productId);
			String productName = product.getName();
			//��Ʒname
			orderItem.setProductName(productName);
			String productImage = product.getFullUrl();
			//��Ʒimage
			orderItem.setProductImage(productImage);
			//��Ʒ����
			orderItem.setCurrentUnitPrice(product.getPrice());
			//��Ʒ�ܼ�
			int totalPrice = product.getPrice().intValue() * item.getAmount();
			orderItem.setTotalPrice(totalPrice);
			
			//��Ʒ����
			orderItem.setQuantity(item.getAmount());
			orderItem.setUserId(userNew.getId());
			orderItem.setOrderNo(orderNo);
			boolean resultItem = orderService.addOrderItem(orderItem);
			System.out.println(orderItem);
		}
		List<OrderItem> list = orderItemService.findByUserId(userNew.getId());
		for (OrderItem orderItemList : list) {
			System.out.println(orderItemList);
		}
		model.addAttribute("list",list);
		model.addAttribute("order",order);
		System.out.println(order);
		
		//������ﳵ
		Cookie cookie = new Cookie("buy_cart_cookies",null);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);

		return "order_list";
	}

}