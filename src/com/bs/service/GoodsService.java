package com.bs.service;

import java.util.List;

import com.bs.entity.Goods;
import com.bs.entity.Search;



public interface GoodsService extends BaseService{
	public void add(Goods goods);
	public void delete(Goods goods);
	public void update(Goods goods);
	public Goods findById(int id);
	public Goods findByUserId(int id);
	public List<Goods> search(Search search);
}

