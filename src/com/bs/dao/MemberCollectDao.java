package com.bs.dao;
import java.util.List;

import com.bs.entity.MemberCollect;
import com.bs.entity.Search;

public interface MemberCollectDao {
public void save(MemberCollect memberCollect);
public void delete(MemberCollect memberCollect);
public void update(MemberCollect memberCollect);
public MemberCollect getById(int id);
public List<MemberCollect> query(Search search);
public MemberCollect getByUserId(int id);
}

