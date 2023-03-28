package com.ezen.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO2;
import com.ezen.biz.dto.MemberVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO2 userDAO;
	
	@Override
	public MemberVO getUser(MemberVO vo) {
		
		return userDAO.getUser(vo);
	}

}
