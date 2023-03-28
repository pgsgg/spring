package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.AddressVO;
import com.ezen.biz.dto.MemberVO;

public interface MemberService {

	// 회원 상세정보 조회
	MemberVO getMember(String id);

	// 회원Id 존재여부 확인
	int confirmID(String userid);

	// 회원 인증
	public int login(MemberVO vo);

	// 회원추가
	void insertMember(MemberVO membervo);

	public List<AddressVO> selectAddressByDong(String dong);

	// 이름과 이메일로 아이디 찾기
	public String selectIdByNameEmail(MemberVO vo);

	// 아이디,이름,이메일로 비밀번호 찾기
	public String selectPwdByIdNameEmail(MemberVO vo);

	public void changePwd(MemberVO vo);
	
	List<MemberVO> getListMember(String name);

}