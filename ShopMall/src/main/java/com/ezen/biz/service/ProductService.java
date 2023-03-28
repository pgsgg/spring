package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	ProductVO getProduct(ProductVO vo);

	List<ProductVO> getProductListByKind(String kind);

	List<ProductVO> getNewProductList();

	List<ProductVO> getBestProductList();
	
	int countProductList(String name);

	List<ProductVO> getListProduct(String name);
	
	List<ProductVO> getListProductWithPaging(String name,Criteria criteria);

	void insertProduct(ProductVO vo);

	void updateProduct(ProductVO vo);
}