package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.CommentMsgDao;
import com.bs.entity.CommentMsg;
import com.bs.entity.Search;
import com.bs.utils.PageContext;


@Repository("commentMsgDao")
public class CommentMsgDaoImpl implements CommentMsgDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(CommentMsg commentMsg) {
		getSession().save(commentMsg);
	}

	public void update(CommentMsg commentMsg) {
		getSession().update(commentMsg);
	}
	
	public void delete(CommentMsg commentMsg) {
		getSession().delete(commentMsg);
	}

	public CommentMsg getById(int id) {
		return (CommentMsg)getSession().load(CommentMsg.class, id);
	}
	
	public CommentMsg getByUserId(int id) {
		CommentMsg commentMsg=null;
		String sql = "select * from t_commentMsg where users = ?";
		try {
			commentMsg = (CommentMsg)getSession().createSQLQuery(sql).addEntity(CommentMsg.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentMsg;
	}
	public List<CommentMsg> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_commentMsg  where 1=1 ";
		if(search.getType().equals("string")){
			sql+=" and name like '%"+search.getString()+"%' ";
		}
		if(!search.getAuthorityName().equals("")){
			sql+=" and "+search.getAuthorityName()+" = "+search.getAuthorityValue()+" ";
		}
		String sqlRecordsCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		sql += " limit ?,?";
		try {
			Integer recordsCount = Integer.valueOf(getSession().createSQLQuery(sqlRecordsCount).uniqueResult().toString());
			PageContext.getPage().setRecordsCount(recordsCount.intValue());
			list =	getSession().createSQLQuery(sql)
					.addEntity(CommentMsg.class)
					.setParameter(0, PageContext.getPage().getPageIndex())
					.setParameter(1, PageContext.getPage().getPageSize())
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	private Session getSession(){
		return  sessionFactory.getCurrentSession();
	}



}
