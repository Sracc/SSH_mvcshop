package com.bs.service;

import java.util.List;

import com.bs.entity.News;
import com.bs.entity.Search;



public interface NewsService extends BaseService{
	public void add(News news);
	public void delete(News news);
	public void update(News news);
	public News findById(int id);
	public News findByUserId(int id);
	public List<News> search(Search search);
}

