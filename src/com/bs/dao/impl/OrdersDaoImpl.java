package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.OrdersDao;
import com.bs.entity.Orders;
import com.bs.entity.Search;
import com.bs.utils.PageContext;


@Repository("ordersDao")
public class OrdersDaoImpl implements OrdersDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void save(Orders orders) {
		getSession().save(orders);
	}

	public void update(Orders orders) {
		getSession().update(orders);
	}
	
	public void delete(Orders orders) {
		getSession().delete(orders);
	}

	public Orders getById(int id) {
		return (Orders)getSession().load(Orders.class, id);
	}
	
	public Orders getByUserId(int id) {
		Orders orders=null;
		String sql = "select * from t_orders where users = ?";
		try {
			orders = (Orders)getSession().createSQLQuery(sql).addEntity(Orders.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	public List<Orders> query(Search search) {
		List list=new ArrayList();
		String sql = "select * from t_orders  where 1=1 ";
		if(search.getType().equals("backend")){
			if(!search.getMembersearch().equals("")){
				sql+="  and member="+search.getMembersearch()+" ";
			}
			if(!search.getGoodssearch().equals("")){
				sql+="  and goods="+search.getGoodssearch()+" ";
			}
			if(!search.getSettimesearch().equals(""))sql+=" and settime like '%"+search.getSettimesearch()+"%' ";
			if(!search.getStatesearch().equals("")){
				sql+="  and state="+search.getStatesearch()+" ";
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
					.addEntity(Orders.class)
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
