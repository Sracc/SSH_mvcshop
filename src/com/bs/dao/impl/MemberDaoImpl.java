package com.bs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bs.dao.MemberDao;
import com.bs.entity.Member;
import com.bs.entity.Search;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Resource
	private SessionFactory sessionFactory;

	public void save(Member member) {
		getSession().save(member);
	}

	public void update(Member member) {
		getSession().update(member);
	}

	public void delete(Member member) {
		getSession().delete(member.getUsers());
		getSession().delete(member);
	}

	public Member getById(int id) {
		return (Member) getSession().load(Member.class, id);
	}

	public Member getByUserId(int id) {
		Member member = null;
		String sql = "select * from t_member where users = ?";
		try {
			member = (Member) getSession().createSQLQuery(sql)
					.addEntity(Member.class).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Member> query(Search search) {
		List list = new ArrayList();
		String sql = "select * from t_member  where 1=1 ";
		if (search.getType().equals("string")) {
			sql += " and name like '%" + search.getString() + "%' ";
		}
		if (!search.getAuthorityName().equals("")) {
			sql += " and " + search.getAuthorityName() + " = "
					+ search.getAuthorityValue() + " ";
		}
		String sqlRecordsCount = "select count(*) "
				+ sql.substring(sql.indexOf("from"));
		sql += " limit ?,?";

		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
