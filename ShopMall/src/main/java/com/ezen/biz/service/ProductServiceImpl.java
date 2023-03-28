package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.ProductDAO;
import com.ezen.biz.dto.ProductVO;

import utils.Criteria;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductVO getProduct(ProductVO vo) {

		return productDAO.getProduct(vo);
	}

	@Override
	public List<ProductVO> getProductListByKind(String kind) {

		return productDAO.getProductListByKind(kind);
	}

	@Override
	public List<ProductVO> getNewProductList() {

		return productDAO.getNewProductList();
	}

	@Override
	public List<ProductVO> getBestProductList() {

		return productDAO.getBestProductList();
	}

	@Override
	public int countProductList(String name) {
		return productDAO.countProductList(name);
	}

	@Override
	public List<ProductVO> getListProduct(String name) {
		return productDAO.listProduct(name);
	}

	@Override
	public List<ProductVO> getListProductWithPaging(String name, Criteria criteria) {

		return productDAO.listProductWithPaging(name, criteria);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		productDAO.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDAO.updateProduct(vo);
	}

}
