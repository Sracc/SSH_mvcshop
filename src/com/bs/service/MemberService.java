package com.bs.service;

import java.util.List;

import com.bs.entity.Member;
import com.bs.entity.Search;

public interface MemberService extends BaseService {
	public void add(Member member);

	public void delete(Member member);

	public void update(Member member);

	public Member findById(int id);

	public Member findByUserId(int id);

	public List<Member> search(Search search);
}
