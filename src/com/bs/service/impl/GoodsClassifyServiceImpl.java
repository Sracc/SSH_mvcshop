package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.GoodsClassifyDao;
import com.bs.entity.GoodsClassify;
import com.bs.entity.Search;
import com.bs.service.GoodsClassifyService;


@Service("goodsClassifyService")
public class GoodsClassifyServiceImpl extends BaseServiceImpl implements GoodsClassifyService {
	@Resource
	GoodsClassifyDao goodsClassifyDao ;
	public void add(GoodsClassify goodsClassify) {
		goodsClassifyDao.save(goodsClassify);
	}

	public void delete(GoodsClassify goodsClassify) {
		goodsClassifyDao.delete(goodsClassify);
	}

	public void update(GoodsClassify goodsClassify) {
		goodsClassifyDao.update(goodsClassify);
	}

	public GoodsClassify findById(int id) {
		return goodsClassifyDao.getById(id);
	}

	public GoodsClassify findByUserId(int id) {
		return goodsClassifyDao.getByUserId(id);
	}

	public List<GoodsClassify> search(Search search) {
		return goodsClassifyDao.query(search);
	}

}
