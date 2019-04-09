package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.MemberCollectDao;
import com.bs.entity.MemberCollect;
import com.bs.entity.Search;
import com.bs.service.MemberCollectService;


@Service("memberCollectService")
public class MemberCollectServiceImpl extends BaseServiceImpl implements MemberCollectService {
	@Resource
	MemberCollectDao memberCollectDao ;
	public void add(MemberCollect memberCollect) {
		memberCollectDao.save(memberCollect);
	}

	public void delete(MemberCollect memberCollect) {
		memberCollectDao.delete(memberCollect);
	}

	public void update(MemberCollect memberCollect) {
		memberCollectDao.update(memberCollect);
	}

	public MemberCollect findById(int id) {
		return memberCollectDao.getById(id);
	}

	public MemberCollect findByUserId(int id) {
		return memberCollectDao.getByUserId(id);
	}

	public List<MemberCollect> search(Search search) {
		return memberCollectDao.query(search);
	}

}
