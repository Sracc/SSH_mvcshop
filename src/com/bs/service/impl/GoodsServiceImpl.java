package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.GoodsDao;
import com.bs.entity.Goods;
import com.bs.entity.Search;
import com.bs.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl implements GoodsService {
	@Resource
	GoodsDao goodsDao ;
	public void add(Goods goods) {
		goodsDao.save(goods);
	}

	public void delete(Goods goods) {
		goodsDao.delete(goods);
	}

	public void update(Goods goods) {
		goodsDao.update(goods);
	}

	public Goods findById(int id) {
		return goodsDao.getById(id);
	}

	public Goods findByUserId(int id) {
		return goodsDao.getByUserId(id);
	}

	public List<Goods> search(Search search) {
		return goodsDao.query(search);
	}

}
