package com.ezen.biz.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.UserVO;

@Repository("userDAO")
public class UserDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserVO getUser(UserVO vo) {
		UserVO result = mybatis.selectOne("userMapper.getUser",vo);
		return result;
	}
}
