package com.situ.mall.service;

import java.util.Map;

import org.springframework.stereotype.Service;

public interface IStaticPageService {
	/**
	 * ��Ʒ����ҳ��̬��
	 * @param root ����
	 * @param id  ��Ʒid
	 */
	public boolean productIndex(Map<String,Object> root,Integer id);
}
