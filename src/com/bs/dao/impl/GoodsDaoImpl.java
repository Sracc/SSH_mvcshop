package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.GoodsDao;
import com.bs.entity.Goods;
import com.bs.entity.Search;
import com.bs.utils.PageContext;


@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Goods goods) {
		getSession().save(goods);
	}

	public void update(Goods goods) {
		getSession().update(goods);
	}
	
	public void delete(Goods goods) {
		getSession().delete(goods);
	}

	public Goods getById(int id) {
		return (Goods)getSession().load(Goods.class, id);
	}
	
	public Goods getByUserId(int id) {
		Goods goods=null;
		String sql = "select * from t_goods where users = ?";
		try {
			goods = (Goods)getSession().createSQLQuery(sql).addEntity(Goods.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	public List<Goods> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_goods  where 1=1 ";
		if(search.getType().equals("backend")){
			if(!search.getNamesearch().equals(""))sql+=" and name like '%"+search.getNamesearch()+"%' ";
			if(!search.getGoodsClassifysearch().equals("")){
				sql+="  and goodsClassify="+search.getGoodsClassifysearch()+" ";
			}
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
					.addEntity(Goods.class)
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
