package com.situ.mall.controller.front;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

@Controller
@RequestMapping(value="cart")
public class CartController {
	
	@Resource(name="productService")
	private IProductService productService;
	
	@RequestMapping("/addCart")
	public String addCart(Integer productId,Integer amount,Model model,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println(productId);
		System.out.println(amount);
		
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		//ֻ�ж������治��null�Ĳ�ת��
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		BuyCartVO buyCartVO = null;
		//1.���cookie��������ﳵ�����Ǿʹ�cookie����ȡ��������ﳵ����
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
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
		
		//2.���cookieû��������ﳵ����,����Ҫnew BuyCartVO
		if (buyCartVO == null) {
			buyCartVO = new BuyCartVO();
		}
		
		//���ﳵ�м��빺����
		if (productId != null) {
			Product productTemp = productService.findById(productId);
			Product product = new Product();
			product.setId(productId);
			product.setStock(productTemp.getStock());
			CartItemVO cartItemVO = new CartItemVO();
			cartItemVO.setProduct(product);
			cartItemVO.setAmount(amount);
			
			buyCartVO.addItem(cartItemVO);
			buyCartVO.setProductId(productId);
			//�ѹ��ﳵ����BuyCartVO��json��ʽд��cookie����
			StringWriter stringWriter = new StringWriter();
			try {
				objectMapper.writeValue(stringWriter, buyCartVO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�����ﳵjson���ݷŵ�cookie����
			Cookie cookie = new Cookie("buy_cart_cookies", stringWriter.toString());
			//cookie�Ĵ��ʱ��,Ĭ�Ϲر����������
			cookie.setMaxAge(60*60*24);
			
			//��cookie���͸������
			response.addCookie(cookie);
		}
		
		//�ŵ�������з��ص�ǰ��չʾ��������ﳵ����Ҫ��Product�����������ݲ���
		List<CartItemVO> items = buyCartVO.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}
		
		model.addAttribute("buyCartVO",buyCartVO);
		return "cart";
	}
	
	@RequestMapping("/deleteCart")
	public String deleteCart(Integer productId,Model model,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println(productId);	
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		//ֻ�ж������治��null�Ĳ�ת��
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		BuyCartVO buyCartVO = null;
		//1.���cookie��������ﳵ�����Ǿʹ�cookie����ȡ��������ﳵ����
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
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
		//���ﳵ�м��빺����
		if (productId != null) {
			Product productTemp = productService.findById(productId);
			Product product = new Product();
			product.setId(productId);
			product.setStock(productTemp.getStock());
			CartItemVO cartItemVO = new CartItemVO();
			cartItemVO.setProduct(product);
			
			buyCartVO.delItems(productId);
			buyCartVO.setProductId(productId);
			
			//�ѹ��ﳵ����BuyCartVO��json��ʽд��cookie����
			StringWriter stringWriter = new StringWriter();
			try {
				objectMapper.writeValue(stringWriter, buyCartVO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//�����ﳵjson���ݷŵ�cookie����
			Cookie cookie = new Cookie("buy_cart_cookies", stringWriter.toString());
			//cookie�Ĵ��ʱ��,Ĭ�Ϲر����������
			cookie.setMaxAge(60*60*24);
			
			//��cookie���͸������
			response.addCookie(cookie);
		}
		
		//�ŵ�������з��ص�ǰ��չʾ��������ﳵ����Ҫ��Product�����������ݲ���
		List<CartItemVO> items = buyCartVO.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}
		
		model.addAttribute("buyCartVO",buyCartVO);
		return "cart";
	}
}