package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.CommentMsgDao;
import com.bs.entity.CommentMsg;
import com.bs.entity.Search;
import com.bs.service.CommentMsgService;


@Service("commentMsgService")
public class CommentMsgServiceImpl extends BaseServiceImpl implements CommentMsgService {
	@Resource
	CommentMsgDao commentMsgDao ;
	public void add(CommentMsg commentMsg) {
		commentMsgDao.save(commentMsg);
	}

	public void delete(CommentMsg commentMsg) {
		commentMsgDao.delete(commentMsg);
	}

	public void update(CommentMsg commentMsg) {
		commentMsgDao.update(commentMsg);
	}

	public CommentMsg findById(int id) {
		return commentMsgDao.getById(id);
	}

	public CommentMsg findByUserId(int id) {
		return commentMsgDao.getByUserId(id);
	}

	public List<CommentMsg> search(Search search) {
		return commentMsgDao.query(search);
	}

}
