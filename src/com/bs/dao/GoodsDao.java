package com.bs.dao;
import java.util.List;

import com.bs.entity.Goods;
import com.bs.entity.Search;

public interface GoodsDao {
public void save(Goods goods);
public void delete(Goods goods);
public void update(Goods goods);
public Goods getById(int id);
public List<Goods> query(Search search);
public Goods getByUserId(int id);
}

