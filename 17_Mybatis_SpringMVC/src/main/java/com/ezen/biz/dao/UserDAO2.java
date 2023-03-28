package com.ezen.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.MemberVO;

@Repository("userDAO")
public class UserDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;	

	public MemberVO getUser(MemberVO user) {
		MemberVO result = mybatis.selectOne("userMapper.getUser", user);
		return result;
	}

}
