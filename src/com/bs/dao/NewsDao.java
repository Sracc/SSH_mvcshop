package com.bs.dao;
import java.util.List;

import com.bs.entity.News;
import com.bs.entity.Search;

public interface NewsDao {
public void save(News news);
public void delete(News news);
public void update(News news);
public News getById(int id);
public List<News> query(Search search);
public News getByUserId(int id);
}

