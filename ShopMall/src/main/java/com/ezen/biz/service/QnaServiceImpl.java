package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.QnaDAO;
import com.ezen.biz.dto.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<QnaVO> getListQna(String id) {
		return qnaDAO.listQna(id);
	}

	@Override
	public QnaVO getQna(int qseq) {
		return qnaDAO.getQna(qseq);
	}

	@Override
	public void insertQna(QnaVO vo) {
		qnaDAO.insertQna(vo);
	}

	@Override
	public List<QnaVO> getListAllQna() {
		return qnaDAO.listAllQna();
	}

	@Override
	public void updateQna(QnaVO vo) {
		qnaDAO.updateQna(vo);
	}

}
