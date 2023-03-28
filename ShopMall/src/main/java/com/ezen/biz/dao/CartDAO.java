package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.CartVO;

@Repository("cartDAO")
public class CartDAO {

	@Autowired
	SqlSessionTemplate mybatis;

	public void insertCart(CartVO vo) {

		mybatis.insert("cartMapper.insertCart", vo);
	}

	public List<CartVO> listCart(String id) {

		return mybatis.selectList("cartMapper.listCart", id);
	}

	public void deleteCart(int cseq) {

		mybatis.delete("cartMapper.deleteCart", cseq);
	}
	
	public void updateCart(int cseq) {

		mybatis.update("cartMapper.updateCart", cseq);
	}
}
