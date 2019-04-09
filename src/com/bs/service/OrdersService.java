package com.bs.service;

import java.util.List;

import com.bs.entity.Orders;
import com.bs.entity.Search;



public interface OrdersService extends BaseService{
	public void add(Orders orders);
	public void delete(Orders orders);
	public void update(Orders orders);
	public Orders findById(int id);
	public Orders findByUserId(int id);
	public List<Orders> search(Search search);
}

