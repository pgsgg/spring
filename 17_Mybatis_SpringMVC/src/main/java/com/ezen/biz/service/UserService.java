package com.ezen.biz.service;

import com.ezen.biz.dto.MemberVO;

public interface UserService {

	// 사용자 조회 
	MemberVO getUser(MemberVO vo);

}