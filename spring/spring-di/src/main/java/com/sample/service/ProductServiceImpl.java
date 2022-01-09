package com.sample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sample.vo.Product;
/*
 * 두개 이상의 자식객체가 있을 때
 * @Primary 기본으로 설정
 * 
 */
@Component("productService1")
@Primary
public class ProductServiceImpl implements ProductService {
	
	@Override
	public Product getProductByNo(int no) {
		return new Product(100, "애플워치", "애플", 650000, 610000);
	}
}
