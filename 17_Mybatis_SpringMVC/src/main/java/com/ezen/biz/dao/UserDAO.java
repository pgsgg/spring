package com.ezen.biz.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.MemberVO;

//@Repository("userDAO")
/*
public class UserDAO extends SqlSessionDaoSupport {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public MemberVO getUser(MemberVO user) {
		SqlSession session = getSqlSession();
		MemberVO result = session.selectOne("userMapper.getUser", user);
		return result;
	}

}
*/