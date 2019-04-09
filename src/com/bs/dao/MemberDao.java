package com.bs.dao;

import java.util.List;

import com.bs.entity.Member;
import com.bs.entity.Search;

public interface MemberDao {
	public void save(Member member);

	public void delete(Member member);

	public void update(Member member);

	public Member getById(int id);

	public List<Member> query(Search search);

	public Member getByUserId(int id);
}
