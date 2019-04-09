package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.StateDao;
import com.bs.entity.Search;
import com.bs.entity.State;
import com.bs.utils.PageContext;


@Repository("stateDao")
public class StateDaoImpl implements StateDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(State state) {
		getSession().save(state);
	}

	public void update(State state) {
		getSession().update(state);
	}
	
	public void delete(State state) {
		getSession().delete(state);
	}

	public State getById(int id) {
		return (State)getSession().load(State.class, id);
	}
	
	public State getByUserId(int id) {
		State state=null;
		String sql = "select * from t_state where users = ?";
		try {
			state = (State)getSession().createSQLQuery(sql).addEntity(State.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	public List<State> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_state  where 1=1 ";
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
					.addEntity(State.class)
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
