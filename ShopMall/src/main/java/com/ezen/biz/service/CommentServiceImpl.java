/**
 * 
 */
package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.CommentDAO;
import com.ezen.biz.dto.ProductCommentVO;

import utils.Criteria;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public int getCountCommentList(int pseq) {
		return commentDAO.countCommentList(pseq);
	}

	@Override
	public List<ProductCommentVO> getCommentListWithPaging(Criteria criteria, int pseq) {
		return commentDAO.commentListWithPaging(criteria, pseq);
	}

	@Override
	public int saveComment(ProductCommentVO vo) {
		// TODO Auto-generated method stub
		return commentDAO.saveComment(vo);
	}

}
