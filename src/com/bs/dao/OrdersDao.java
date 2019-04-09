package com.bs.dao;
import java.util.List;

import com.bs.entity.Orders;
import com.bs.entity.Search;

public interface OrdersDao {
public void save(Orders orders);
public void delete(Orders orders);
public void update(Orders orders);
public Orders getById(int id);
public List<Orders> query(Search search);
public Orders getByUserId(int id);
}

