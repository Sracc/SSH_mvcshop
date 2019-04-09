package com.bs.service;

import java.util.List;

import com.bs.entity.CommentMsg;
import com.bs.entity.Search;



public interface CommentMsgService extends BaseService{
	public void add(CommentMsg commentMsg);
	public void delete(CommentMsg commentMsg);
	public void update(CommentMsg commentMsg);
	public CommentMsg findById(int id);
	public CommentMsg findByUserId(int id);
	public List<CommentMsg> search(Search search);
}

