package com.sample.service;

import org.springframework.stereotype.Component;

import com.sample.vo.Product;

@Component("productService2")
public class ProductServiceImpl2 implements ProductService {
	@Override
	public Product getProductByNo(int no) {
		return new Product(200, "갤럭시워치", "삼성", 500000, 450000);
	}
}
