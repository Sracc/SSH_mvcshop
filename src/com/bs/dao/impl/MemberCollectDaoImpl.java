package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.MemberCollectDao;
import com.bs.entity.MemberCollect;
import com.bs.entity.Search;
import com.bs.utils.PageContext;


@Repository("memberCollectDao")
public class MemberCollectDaoImpl implements MemberCollectDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(MemberCollect memberCollect) {
		getSession().save(memberCollect);
	}

	public void update(MemberCollect memberCollect) {
		getSession().update(memberCollect);
	}
	
	public void delete(MemberCollect memberCollect) {
		getSession().delete(memberCollect);
	}

	public MemberCollect getById(int id) {
		return (MemberCollect)getSession().load(MemberCollect.class, id);
	}
	
	public MemberCollect getByUserId(int id) {
		MemberCollect memberCollect=null;
		String sql = "select * from t_memberCollect where users = ?";
		try {
			memberCollect = (MemberCollect)getSession().createSQLQuery(sql).addEntity(MemberCollect.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberCollect;
	}
	public List<MemberCollect> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_memberCollect  where 1=1 ";
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
					.addEntity(MemberCollect.class)
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
