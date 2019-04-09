package com.bs.dao;
import java.util.List;

import com.bs.entity.CommentMsg;
import com.bs.entity.Search;

public interface CommentMsgDao {
public void save(CommentMsg commentMsg);
public void delete(CommentMsg commentMsg);
public void update(CommentMsg commentMsg);
public CommentMsg getById(int id);
public List<CommentMsg> query(Search search);
public CommentMsg getByUserId(int id);
}

