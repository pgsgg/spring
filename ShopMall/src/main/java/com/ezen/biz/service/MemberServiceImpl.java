package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ezen.biz.dao.MemberDAO;
import com.ezen.biz.dto.AddressVO;
import com.ezen.biz.dto.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public int confirmID(String userid) {
		return memberDAO.confirmID(userid);
	}

	@Override
	public void insertMember(MemberVO membervo) {
		memberDAO.insertMember(membervo);
	}

	@Override
	public List<AddressVO> selectAddressByDong(String dong) {
		return memberDAO.selectAddressByDong(dong);
	}

	@Override
	public String selectIdByNameEmail(MemberVO vo) {
		return memberDAO.selectIdByNameEmail(vo);
	}

	@Override
	public String selectPwdByIdNameEmail(MemberVO vo) {
		return memberDAO.selectIdByNameEmail(vo);
	}

	@Override
	public void changePwd(MemberVO vo) {
		memberDAO.changePwd(vo);
	}

	@Override
	public int login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	@Override
	public List<MemberVO> getListMember(String name) {
		return memberDAO.listMember(name);
	}

}
