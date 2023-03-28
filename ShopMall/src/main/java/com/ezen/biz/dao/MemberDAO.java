package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.AddressVO;
import com.ezen.biz.dto.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 회원 상세정보 조회
	public MemberVO getMember(String id) {

		return mybatis.selectOne("MemberMapper.getMember", id);
	}

	// 회원Id 존재여부 확인
	public int confirmID(String userid) {
		String pwd = mybatis.selectOne("MemberMapper.confirmID", userid);
		if (pwd != null) {
			return 1;
		} else {
			return 0;
		}
	}
	//회원 로그인 확인
	public int login(MemberVO vo) {
		int result = -1;
		String pwd = mybatis.selectOne("MemberMapper.confirmID", vo);
		if(pwd == null) { // id가 존재하지 않는다
			result = -1;
		} else if(pwd.equals(vo.getPwd())) { //정상 로그인
			result = 1;
		} else { // 비밀번호 불일치
			result = 0;
		}
		return result;
	}
	
	// 회원추가
	public void insertMember(MemberVO membervo) {

		mybatis.insert("MemberMapper.insertMember", membervo);
	}

	public List<AddressVO> selectAddressByDong(String dong) {

		return mybatis.selectList("MemberMapper.selectAddressByDong", dong);
	}
	//이름과 이메일로 아이디 찾기
	public String selectIdByNameEmail(MemberVO vo) {
		
		return mybatis.selectOne("MemberMapper.selectIdByNameEmail", vo);
	}
	//아이디,이름,이메일로 비밀번호 찾기
	public String selectPwdByIdNameEmail(MemberVO vo) {
		
		return mybatis.selectOne("MemberMapper.selectPwdByIdNameEmail", vo);
	}
	
	public void changePwd(MemberVO vo) {
		
		mybatis.update("MemberMapper.changePwd", vo);
	}
	
	public List<MemberVO> listMember(String name) {
		
		return mybatis.selectList("MemberMapper.listMember", name);
	}
}
