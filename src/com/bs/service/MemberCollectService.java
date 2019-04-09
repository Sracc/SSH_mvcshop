package com.bs.service;

import java.util.List;

import com.bs.entity.MemberCollect;
import com.bs.entity.Search;



public interface MemberCollectService extends BaseService{
	public void add(MemberCollect memberCollect);
	public void delete(MemberCollect memberCollect);
	public void update(MemberCollect memberCollect);
	public MemberCollect findById(int id);
	public MemberCollect findByUserId(int id);
	public List<MemberCollect> search(Search search);
}

