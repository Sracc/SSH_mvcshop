package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bs.dao.MemberDao;
import com.bs.entity.Member;
import com.bs.entity.Search;
import com.bs.service.MemberService;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl implements MemberService {
	@Resource
	MemberDao memberDao;

	public void add(Member member) {
		memberDao.save(member);
	}

	public void delete(Member member) {
		memberDao.delete(member);
	}

	public void update(Member member) {
		memberDao.update(member);
	}

	public Member findById(int id) {
		return memberDao.getById(id);
	}

	public Member findByUserId(int id) {
		return memberDao.getByUserId(id);
	}

	public List<Member> search(Search search) {
		return memberDao.query(search);
	}

}
